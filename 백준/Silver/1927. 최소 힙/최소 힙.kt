import java.io.Writer
import java.util.*

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val size = reader.readLine().toInt()
        val queue = PriorityQueue<Int>()
        repeat(size) {
            val number = reader.readLine().toInt()
            if (number == 0) {
                writer.writeLine(
                    if (queue.isNotEmpty()) queue.poll() else 0
                )
            } else {
                queue.add(number)
            }
        }
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}