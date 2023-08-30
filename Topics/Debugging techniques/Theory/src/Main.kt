// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
  // put your code here
}

class Animal(val name: String) {
    init {
        check(name.isNotBlank()) { "Name must not be blank" }
    }
}