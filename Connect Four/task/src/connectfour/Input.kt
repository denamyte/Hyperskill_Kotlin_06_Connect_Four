package connectfour

val DIM_REGEX = Regex("""\s*\d+\s*[xX]\s*\d+\s*""")
val NUMBER_REGEX = Regex("\\d+")
const val DEFAULT_ROWS = 6
const val DEFAULT_COLUMNS = 7
val DIM_RANGE = 5..9

class Input {

    private var name1: String = ""
    private var name2: String = ""
    private var rows: Int = DEFAULT_ROWS
    private var columns: Int = DEFAULT_COLUMNS

    fun run() {
        greeting()
        name1 = inputName("First")
        name2 = inputName("Second")
        inputBoardDimensions()
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

    private fun showParams() {
        println(
            """
            $name1 VS $name2
            $rows x $columns board""".trimIndent()
        )
    }

}