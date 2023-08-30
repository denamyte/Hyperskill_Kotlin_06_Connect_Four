fun main() {
    List(2) { readln().toInt() }
        .reduce { a, b -> a * b }
        .let {
            print(
                if (it == 0) "It can't be zero!"
                else it
            )
        }
}