fun main() {
    repeat(readln().toInt()) {
        val operations = readln().toCharArray()
        readln()
        val arrInput = readln()
        if (arrInput == "[]") {
            println(if (operations.contains('D')) "error" else "[]")
            return@repeat
        }
        val arr = arrInput.slice(1..<arrInput.lastIndex).split(",").map(String::toInt)
        val queue = ArrayDeque(arr)
        var reversed = false
        operations.forEach { operation ->
            when (operation) {
                'D' -> {
                    if (queue.isEmpty()) {
                        println("error")
                        return@repeat
                    }
                    if (!reversed) {
                        queue.removeFirst()
                    } else {
                        queue.removeLast()
                    }
                }
                'R' -> reversed = !reversed
            }
        }
        val result = if (!reversed) queue else queue.asReversed()
        println(result.joinToString(prefix = "[", separator = ",", postfix = "]"))
    }
}