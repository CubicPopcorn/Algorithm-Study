fun main() {
    val (n, r) = readln().split(" ").map(String::toInt)
    val result = (n - r + 1..n).fold(1) { acc, i -> acc * i } / (1..r).fold(1) { acc, i -> acc * i }
    println(result)
}