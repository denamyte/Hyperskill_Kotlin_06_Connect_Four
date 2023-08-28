package connectfour

class Game(private val board: Board,
           private val players: Array<Player>) {

    fun run() {
        var playerIndex = 0
        var end = false
        while (!end) {
            board.print()
            val player = players[playerIndex]

            while (true) {
                println("${player.name}'s turn:")
                val sMove = readln()

                if (sMove == "end") {
                    end = true
                    break
                }

                if (!NUMBER_REGEX.matches(sMove)) {
                    println("Incorrect column number")
                    continue
                }

                val move = sMove.toInt() - 1
                if (!board.checkColumnErrors(move)) continue

                board.makeMove(move, player.marker)
                break
            }
            playerIndex = (playerIndex + 1) % players.size
        }
        println("Game over!")
    }

}