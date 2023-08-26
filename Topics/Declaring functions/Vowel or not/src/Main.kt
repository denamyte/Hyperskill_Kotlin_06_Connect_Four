// write your function here

fun main() {
    val letter = readln().first()

    println(isVowel(letter))
}

fun isVowel(letter: Char) = letter in "aeiouAEIOU"
