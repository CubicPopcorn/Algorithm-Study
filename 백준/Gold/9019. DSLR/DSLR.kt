fun main() {
    repeat(readln().toInt()) {
        val (initial, goal) = readln().split(" ").map(String::toInt)
        val operations = Array<String?>(10000) { null }
        operations[initial] = ""
        val numberQueue = ArrayDeque<Int>()
        numberQueue.add(initial)

        while (true) {
            val queueSize = numberQueue.size
            for (i in 0..<queueSize) {
                val number = numberQueue.removeFirst()
                val operation = operations[number]
                if (number == goal) {
                    println(operation)
                    return@repeat
                }
                fun tryOperation(op: String, newNumber: Int) {
                    if (operations[newNumber].isNullOrEmpty()) {
                        operations[newNumber] = operation + op
                        numberQueue.addLast(newNumber)
                    }
                }
                tryOperation("D", number * 2 % 10000)
                tryOperation("S", if (number != 0) number - 1 else 9999)
                tryOperation("L", number % 1000 * 10 + number / 1000)
                tryOperation("R", number % 10 * 1000 + number / 10)
            }
        }
    }
}