
import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val list = List(reader.readLine().toInt()) { reader.readLine().toInt() }
        writer.writeLine(list.sorted().joinToString("\n"))
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}