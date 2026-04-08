import kotlin.math.abs

fun main() {
    val (a, b) = readln().split(" ").map(String::toLong)
    println(abs(a - b))
}