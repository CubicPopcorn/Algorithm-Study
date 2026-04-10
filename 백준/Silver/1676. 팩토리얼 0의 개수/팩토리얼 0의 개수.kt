import kotlin.math.min

fun main() {
    val n = readln().toInt()
    var two = 0
    var five = 0
    for (i in 1..n) {
        var remaining = i
        while (remaining % 2 == 0) {
            two++
            remaining /= 2
        }
        while (remaining % 5 == 0) {
            five++
            remaining /= 5
        }
    }
    println(min(two, five))
}