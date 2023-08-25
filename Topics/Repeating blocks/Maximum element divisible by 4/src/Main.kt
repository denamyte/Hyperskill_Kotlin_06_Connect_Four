const val DIV = 4
var max = 0

fun main() {
    repeat(readln().toInt()) {
        val x = readln().toInt()
        if (x % DIV == 0 && x > max) max = x
    }
    println(max)
}