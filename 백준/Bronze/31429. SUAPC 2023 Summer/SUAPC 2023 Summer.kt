fun main() {
    val results = listOf(
        Result(totalSolved = 12, penalty = 1600),
        Result(totalSolved = 11, penalty = 894),
        Result(totalSolved = 11, penalty = 1327),
        Result(totalSolved = 10, penalty = 1311),
        Result(totalSolved = 9, penalty = 1004),
        Result(totalSolved = 9, penalty = 1178),
        Result(totalSolved = 9, 1357),
        Result(totalSolved = 8, 837),
        Result(totalSolved = 7, 1055),
        Result(totalSolved = 6, 556),
        Result(totalSolved = 6, 773),
    )
    val input = readln().toInt()
    val result = results[input - 1]
    println("${result.totalSolved} ${result.penalty}")
}

data class Result(val totalSolved: Int, val penalty: Int)