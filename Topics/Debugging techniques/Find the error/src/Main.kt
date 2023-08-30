import java.util.Scanner

fun swapInts(ints: IntArray): IntArray {
    return ints.reversed().toIntArray()
}

fun main() {
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        var ints = intArrayOf(
            scanner.nextLine().toInt(),
            scanner.nextLine().toInt(),
        )
        ints = swapInts(ints)
        println(ints[0])
        println(ints[1])
    }
}