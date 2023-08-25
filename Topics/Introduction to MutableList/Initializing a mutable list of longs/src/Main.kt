fun main() {
    var hb = 100_000_000_000
    println(MutableList(3) { ++hb }.joinToString())
}