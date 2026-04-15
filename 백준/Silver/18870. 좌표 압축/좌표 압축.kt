
import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val size = readln().toInt()
        val list = readln().split(" ").mapIndexed { i, s -> Element(index = i, value = s.toInt()) }
        val sorted = list.sortedBy { it.value }

        val result = IntArray(size)
        val first = sorted.first()
        result[first.index] = 0
        var uniqueNumbers = 1
        for (i in 1..sorted.lastIndex) {
            if (sorted[i].value != sorted[i - 1].value) {
                uniqueNumbers++
            }
            result[sorted[i].index] = uniqueNumbers - 1
        }
        writer.writeLine(result.joinToString(" "))
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}

data class Element(val index: Int, val value: Int)