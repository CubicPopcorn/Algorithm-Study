import kotlin.math.sqrt

fun main() {
    readln()
    val numbers = readln().split(" ").map(String::toInt)
    val primeTable = BooleanArray(1000) { true }
    primeTable[0] = false
    for (i in 2..sqrt(1000.0).toInt()) {
        if (!primeTable[i - 1]) continue
        for (j in i * 2..1000 step i) {
            primeTable[j - 1] = false
        }
    }
    println(numbers.count { primeTable[it - 1] })
}