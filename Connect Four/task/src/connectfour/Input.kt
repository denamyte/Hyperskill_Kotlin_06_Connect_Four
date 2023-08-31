package connectfour

val DIM_REGEX = Regex("""\s*\d+\s*[xX]\s*\d+\s*""")
val NUMBER_REGEX = Regex("\\d+")
const val DEFAULT_ROWS = 6
const val DEFAULT_COLUMNS = 7
val DIM_RANGE = 5..9

class Input {

    private var name1: String = ""
    private var name2: String = ""
    var rows: Int = DEFAULT_ROWS
        private set
    var columns: Int = DEFAULT_COLUMNS
        private set
    var gamesNumber: Int = 0
        private set

    val players: Array<Player>
        get() = arrayOf(
            Player(name1, 'o'),
            Player(name2, '*')
        )

    fun run() {
        greeting()
        name1 = inputName("First")
        name2 = inputName("Second")
        inputBoardDimensions()
        inputGamesNumber()
        showParams()
    }

    private fun greeting() = println("Connect Four")

    private fun inputName(number: String): String {
        println("$number player's name:")
        return readln()
    }

    private fun inputBoardDimensions() {
        while (true) {
            println(
                """
                Set the board dimensions (Rows x Columns)
                Press Enter for default (6 x 7)""".trimIndent()
            )
            val rawDim = readln()

            if (rawDim.isEmpty()) return

            if (!DIM_REGEX.matches(rawDim)) {
                println("Invalid input")
                continue
            }

            var match = NUMBER_REGEX.find(rawDim) ?: continue
            rows = match.value.toInt()
            if (!checkDimension(rows, "rows")) continue

            match = match.next() ?: continue
            columns = match.value.toInt()
            if (!checkDimension(columns, "columns")) continue

            return
        }
    }

    private fun checkDimension(dim: Int, what: String): Boolean {
        if (dim !in DIM_RANGE) {
            println("Board $what should be from ${DIM_RANGE.first} to ${DIM_RANGE.last}")
            return false
        }
        return true
    }

    private fun inputGamesNumber() {
        while (gamesNumber == 0) {
            println("""
                Do you want to play single or multiple games?
                For a single game, input 1 or press Enter
                Input a number of games:
            """.trimIndent())
            var raw = readln()
            if (raw == "") raw = "1"
            if (NUMBER_REGEX.matches(raw) && raw.toInt() > 0)
                gamesNumber = raw.toInt()
            else println("Invalid input")
        }
    }

    private fun showParams() {
        val gamesMsg = if (gamesNumber == 1) "Single game"
        else "Total $gamesNumber games"
        println(
            """
            $name1 VS $name2
            $rows x $columns board
            $gamesMsg""".trimIndent()

        )
    }

}