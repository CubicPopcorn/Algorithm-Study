fun main() {
    val input = readln().toCharArray().map {
        if (it != '*') it - '0' else null
    }
    fun getWeight(index: Int) = if (index % 2 == 0) 1 else 3
    val compromisedIndex = input.indexOf(null)
    val compromisedWeight = getWeight(compromisedIndex)
    val sum = input.subList(0, input.size - 1).foldIndexed(0) { index, acc, digit ->
        acc + (digit ?: 0) * getWeight(index)
    }
    val checkSign = input.last()!!
    for (i in 0..9) {
        if ((sum + i * compromisedWeight + checkSign) % 10 == 0) {
            println(i)
            return
        }
    }
}