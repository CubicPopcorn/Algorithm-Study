import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val n = reader.readLine().toInt()
        val inputSequence = List(n) { reader.readLine().toInt() }

        val resultBuilder = StringBuilder()
        var lastAddedNumber = 0
        val stack = ArrayDeque<Int>()
        for (item in inputSequence) {
            if (item > lastAddedNumber) {
                stack.addAll(lastAddedNumber + 1..<item)
                resultBuilder.appendLine("+\n".repeat(item - lastAddedNumber) + "-")
                lastAddedNumber = item
            } else if (item != stack.last()) {
                writer.writeLine("NO")
                return
            } else {
                stack.removeLast()
                resultBuilder.appendLine("-")
            }
        }
        writer.writeLine(resultBuilder)
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}