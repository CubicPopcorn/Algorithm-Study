fun main() {
    val n = readln().toInt()
    val findLength = n * 2 + 1
    readln()
    val input = readln()

    var count = 0
    var i = 0
    while (i <= input.lastIndex - (findLength - 1)) {
        val match = run {
            for (j in 0..<findLength) {
                val correctChar = if (j % 2 == 0) 'I' else 'O'
                if (input[i + j] != correctChar) return@run false
            }
            return@run true
        }
        if (match) {
            count++
            i += findLength
            while (i + 1 in input.indices
                && input[i] == 'O'
                && input[i + 1] == 'I') {
                count++
                i += 2
            }
        } else {
            i++
        }
    }
    println(count)
}