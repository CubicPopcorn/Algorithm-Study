import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val stack = ArrayDeque<Int>()
        repeat(readln().toInt()) {
            val input = reader.readLine().split(" ")
            when (input[0]) {
                "push" -> stack.addLast(input[1].toInt())
                "pop" -> writer.writeLine(stack.removeLastOrNull() ?: -1)
                "size" -> writer.writeLine(stack.size)
                "empty" -> writer.writeLine(if (stack.isEmpty()) 1 else 0)
                else -> writer.writeLine(stack.lastOrNull() ?: -1)
            }
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}