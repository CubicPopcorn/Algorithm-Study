fun main() {
    val (initial, goal) = readln().split(" ").map(String::toInt)
    val visitedNumbers = mutableSetOf(initial)
    val numberQueue = ArrayDeque<Int>()
    numberQueue.add(initial)

    var steps = 0
    while (numberQueue.isNotEmpty()) {
        val queueSize = numberQueue.size
        for (i in 0..<queueSize) {
            val number = numberQueue.removeFirst()
            if (number == goal) {
                println(steps + 1)
                return
            }
            fun tryOperation(newNumber: Long) {
                if (newNumber > goal) return
                val newInt = newNumber.toInt()
                if (newNumber <= goal && newInt !in visitedNumbers) {
                    visitedNumbers.add(newInt)
                    numberQueue.addLast(newInt)
                }
            }
            tryOperation(number.toLong() * 2)
            tryOperation(number.toLong() * 10 + 1)
        }
        steps++
    }
    println(-1)
}