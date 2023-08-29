package connectfour

class Game(private val board: Board,
           private val players: Array<Player>) {

    fun run() {
        var playerIndex = 0
        var finished = false
        while (!finished) {
            board.print()
            val player = players[playerIndex]

            while (true) {
                println("${player.name}'s turn:")
                val sMove = readln()

                if (sMove == "end") {
                    finished = true
                    break
                }

                if (!NUMBER_REGEX.matches(sMove)) {
                    println("Incorrect column number")
                    continue
                }

                val move = sMove.toInt() - 1
                if (board.inputRangeErrors(move)) continue

                board.makeMove(move, player.marker)

                if (board.isWinningCondition()) {
                    board.print()
                    println("Player ${player.name} won")
                    finished = true
                    break
                }

                if (board.isDraw()) {
                    board.print()
                    println("It is a draw")
                    finished = true
                }

                break
            }
            playerIndex = (playerIndex + 1) % players.size
        }
        println("Game over!")
    }

}