package connectfour

class Board(private val rows: Int, private val columns: Int) {

    private val field = Array(rows) { Array(columns) {' '} }

    private val caption = (1..columns).joinToString("") { " $it" }
    private val row = Array(columns + 1) { '║' }.joinToString("%c")
    private val footer = '╚' + Array(columns) {'═'}.joinToString("╩") + '╝'

    fun print() {
        println(caption)
        field.forEach { println(row.format(*it)) }
        println(footer)
    }
}