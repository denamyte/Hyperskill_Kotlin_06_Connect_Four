package connectfour

fun main() {
    val input = Input()
    input.run()
    Board(input.rows, input.columns).print()
}