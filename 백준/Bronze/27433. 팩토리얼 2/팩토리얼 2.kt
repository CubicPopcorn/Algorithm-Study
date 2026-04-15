fun main() {
    val n = readln().toInt()
    println((1..n).fold(1L) { acc, i -> acc * i })
}