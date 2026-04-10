import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val size = reader.readLine().toInt()
        val list = List(size) { reader.readLine().toInt() }
        writer.writeLine(list.sorted().joinToString(separator = "\n"))
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}