package connectfour

fun main() {
    val input = Input()
    input.run()
    Game(
        Board(input.rows, input.columns),
        input.players
    ).run()
}