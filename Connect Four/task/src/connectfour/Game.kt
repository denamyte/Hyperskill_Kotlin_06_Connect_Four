package connectfour

class Game(
    private val board: Board,
    private val players: Array<Player>,
    private val gamesNumber: Int
) {
    private var end = false
    private var playerIndex: Int = 0

    fun run() {
        var gamesPlayed = 0
        while (gamesPlayed < gamesNumber) {
            board.initialize()
            gamesPlayed++
            playerIndex = (gamesPlayed + 1) % 2
            if (gamesNumber > 1) println("Game #$gamesPlayed")
            playGame()
            if (end) break
            if (gamesNumber > 1) {
                val score = players.joinToString(" ") { "${it.name}: ${it.score}" }
                println("""
                    Score
                    $score
                    """.trimIndent())
            }
        }
        println("Game over!")
    }

    private fun playGame() {
        var finished = false
        while (!finished) {
            board.print()
            val player = players[playerIndex]

            while (true) {
                println("${player.name}'s turn:")
                val sMove = readln()

                if (sMove == "end") {
                    finished = true
                    end = true
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
                    player.won()
                    board.print()
                    println("Player ${player.name} won")
                    finished = true
                    break
                }

                if (board.isDraw()) {
                    players.forEach { it.draw() }
                    board.print()
                    println("It is a draw")
                    finished = true
                }

                break
            }
            playerIndex = (playerIndex + 1) % players.size
        }
    }

}