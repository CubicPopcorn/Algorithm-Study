fun main() {
    val caseCounts = IntArray(10)
    caseCounts[0] = 1
    caseCounts[1] = 2
    caseCounts[2] = 4
    for (i in 3..<10) {
        caseCounts[i] += caseCounts[i - 1] + caseCounts[i - 2] + caseCounts[i - 3]
    }
    repeat(readln().toInt()) {
        val query = readln().toInt()
        println(caseCounts[query - 1])
    }
}