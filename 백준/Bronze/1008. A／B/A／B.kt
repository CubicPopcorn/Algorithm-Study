import java.math.BigDecimal

fun main() {
    val (a, b) = readln().split(" ").map { BigDecimal(it).setScale(9) }
    println(a / b)
}