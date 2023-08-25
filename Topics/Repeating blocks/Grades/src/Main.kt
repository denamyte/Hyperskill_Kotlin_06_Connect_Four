fun main() {
    val grades = IntArray(readln().toInt()) { readln().toInt() }
    val nGradeTypes = 4
    var curGrade = 2
    val counts = IntArray(nGradeTypes) { curGrade++ }.map { type -> grades.count { it == type } }
    println(counts.joinToString(" "))
}