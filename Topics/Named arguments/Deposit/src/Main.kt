import kotlin.math.pow

val params = mutableMapOf(
    "amount" to 1000.0,
    "percent" to 5.0,
    "years" to 10.0
)

fun main() {
    val key = readln()
    params[key] = readln().toDouble()

    val amount = params["amount"] ?: 1.0
    val percent = params["percent"] ?: 1.0
    val years = params["years"] ?: 1.0

    print((amount * (1 + percent / 100).pow(years)).toInt())
}