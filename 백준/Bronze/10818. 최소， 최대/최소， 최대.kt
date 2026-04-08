fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map(String::toInt)
    println("${numbers.min()} ${numbers.max()}")
}