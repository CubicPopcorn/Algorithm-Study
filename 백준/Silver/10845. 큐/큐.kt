import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val queue = ArrayDeque<Int>()
        repeat(readln().toInt()) {
            val input = reader.readLine().split(" ")
            when (input[0]) {
                "push" -> queue.addLast(input[1].toInt())
                "pop" -> writer.writeLine(queue.removeFirstOrNull() ?: -1)
                "size" -> writer.writeLine(queue.size)
                "empty" -> writer.writeLine(if (queue.isEmpty()) 1 else 0)
                "front" -> writer.writeLine(queue.firstOrNull() ?: -1)
                else -> writer.writeLine(queue.lastOrNull() ?: -1)
            }
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}