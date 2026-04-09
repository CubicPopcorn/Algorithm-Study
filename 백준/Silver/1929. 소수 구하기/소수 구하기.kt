import kotlin.math.sqrt

fun main() {
    val (lowerBound, higherBound) = readln().split(" ").map(String::toInt)
    val primeTable = BooleanArray(higherBound) { true }
    primeTable[0] = false
    for (i in 2..sqrt(higherBound.toDouble()).toInt()) {
        if (!primeTable[i - 1]) continue
        for (j in i * 2..higherBound step i) {
            primeTable[j - 1] = false
        }
    }
    primeTable.forEachIndexed { index, isPrime ->
        val number = index + 1
        if (isPrime && number in lowerBound..higherBound) {
            println(number)
        }
    }
}