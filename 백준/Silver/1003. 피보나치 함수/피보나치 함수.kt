import kotlin.math.max

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val calls = IntArray(max(2, n + 1))
        calls[n] = 1
        for (i in n downTo 2) {
            calls[i - 1] += calls[i]
            calls[i - 2] += calls[i]
        }
        println("${calls[0]} ${calls[1]}")
    }
}