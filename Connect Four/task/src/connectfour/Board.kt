package connectfour

class Board(private val rows: Int, private val columns: Int) {

    private val colRange = 0 until columns
    private val field = Array(rows) { Array(columns) {' '} }
    private val levels = MutableList(columns) {0}

    private val caption = (1..columns).joinToString("") { " $it" }
    private val row = Array(columns + 1) { '║' }.joinToString("%c")
    private val footer = '╚' + Array(columns) {'═'}.joinToString("╩") + '╝'

    var lastError: String = ""
        private set

    fun print() {
        println(caption)
        field.reversed().forEach { println(row.format(*it)) }
        println(footer)
    }

    fun checkColumnErrors(column: Int): Boolean {
        if (column !in colRange) {
            println("The column number is out of range (1 - $columns)")
            return false
        }
        if (levels[column] == rows) {
            println("Column ${column + 1} is full")
            return false
        }
        return true
    }

    fun makeMove(column: Int, move: Char) {
        field[levels[column]][column] = move
        levels[column] += 1
    }
}