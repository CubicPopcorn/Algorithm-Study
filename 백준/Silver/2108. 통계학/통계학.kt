import java.io.Writer
import kotlin.math.roundToInt

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val list = List(reader.readLine().toInt()) { reader.readLine().toInt() }
        val sorted = list.sorted()
        writer.writeLine(list.average().roundToInt())
        writer.writeLine(sorted[sorted.size / 2])
        val frequencies: Map<Int, Int> = buildMap {
            sorted.forEach {
                this[it] = this.getOrDefault(it, 0) + 1
            }
        }
        val sortedOfMostFrequency = frequencies.entries
            .sortedWith(compareBy<Map.Entry<Int, Int>> { it.value }.reversed())
            .let { li ->
                li.filter { it.value == li[0].value }
                    .map { it.key }
                    .sorted()
            }
        if (sortedOfMostFrequency.size == 1) {
            writer.writeLine(sortedOfMostFrequency[0])
        } else {
            writer.writeLine(sortedOfMostFrequency[1])
        }
        writer.writeLine(sorted.last() - sorted.first())
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}