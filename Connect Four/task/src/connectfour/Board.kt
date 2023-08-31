package connectfour

val markerValues = mapOf('o' to 1, '*' to -1, ' ' to 0)

class Board(private val rows: Int, private val columns: Int) {

    private val rowRange = 0 until rows
    private val colRange = 0 until columns
    private lateinit var field: List<MutableList<Char>>
    private lateinit var levels: MutableList<Int>

    private val caption = (1..columns).joinToString("") { " $it" }
    private val row = Array(columns + 1) { '║' }.joinToString("%c")
    private val footer = '╚' + Array(columns) {'═'}.joinToString("╩") + '╝'

    fun initialize() {
        field = List(rows) { MutableList(columns) { ' ' } }
        levels = MutableList(columns) {0}
    }

    fun print() {
        println(caption)
        field.reversed().forEach { println(row.format(*it.toTypedArray())) }
        println(footer)
    }

    fun inputRangeErrors(column: Int): Boolean {
        if (column !in colRange) {
            println("The column number is out of range (1 - $columns)")
            return true
        }
        if (levels[column] == rows) {
            println("Column ${column + 1} is full")
            return true
        }
        return false
    }

    fun isWinningCondition(): Boolean {
        // Horizontal checks
        if (field.any { isWinningCondition(it) }) return true

        // Vertical checks
        colRange.forEach { it ->
            val col = it
            val colData = rowRange.map { it1 ->
                val row = it1
                field[row][col]
            }
            if (isWinningCondition(colData)) return true
        }

        // Diagonal checks
        return isSlashDiagonalWin() || isBackslashDiagonalWin()
    }

    private fun isSlashDiagonalWin(): Boolean {
        for (startCol in columns - 4 downTo 4 - rows) {
            val line = rowRange.zip(startCol until startCol + rows)
                .map {
                    if (it.second !in colRange) ' ' else field[it.first][it.second]
                }
            if (isWinningCondition(line)) return true
        }
        return false
    }

    private fun isBackslashDiagonalWin(): Boolean {
        for (startCol in 3 until columns + rows - 4) {
            val line = rowRange.zip(startCol downTo startCol - rows + 1)
                .map {
                    if (it.second !in colRange) ' ' else field[it.first][it.second]
                }
            if (isWinningCondition(line)) return true
        }
        return false
    }

    private fun isWinningCondition(line: Iterable<Char>): Boolean {
        val intLine = line.map { markerValues.getOrDefault(it, 0) }.toMutableList()
        for (i in 1..intLine.lastIndex)
            if (intLine[i - 1] < 0 && intLine[i] < 0 || intLine[i - 1] > 0 && intLine[i] > 0)
                intLine[i] += intLine[i - 1]

        return intLine.any { it == -4 || it == 4 }
    }

    fun isDraw(): Boolean = levels.all { it == rows }

    fun makeMove(column: Int, move: Char) {
        field[levels[column]][column] = move
        levels[column] += 1
    }
}