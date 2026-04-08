fun main() {
    val n = readln()
    val numbers = readln().split(" ").map(String::toInt)
    val findNumber = readln().toInt()
    println(numbers.count { it == findNumber })
}