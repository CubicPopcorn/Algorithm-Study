import java.io.Writer
import kotlin.math.roundToInt

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val list = List(reader.readLine().toInt()) { reader.readLine().toInt() }
        if (list.isEmpty()) {
            writer.writeLine(0)
            return
        }
        val truncSize = (list.size * 0.15).roundToInt()
        val truncated = list.sorted().subList(truncSize, list.size - truncSize)
        writer.writeLine(truncated.average().roundToInt())
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}