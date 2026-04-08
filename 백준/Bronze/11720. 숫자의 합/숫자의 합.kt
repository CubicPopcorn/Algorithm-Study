fun main() {
    val n = readln().toInt()
    val sum = readln().fold(0) { acc, char -> acc + char.code - '0'.code }
    println(sum)
}