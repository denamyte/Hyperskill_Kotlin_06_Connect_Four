package connectfour

class Player(val name: String, val marker: Char) {
    var score: Int = 0
        private set

    fun won() {
        score += 2
    }

    fun draw() {
        score += 1
    }
}