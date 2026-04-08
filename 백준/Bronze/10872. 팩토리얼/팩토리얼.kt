fun main() {
    val n = readln().toInt()
    println((2..n).fold(1) { acc, num -> acc * num })
}