import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        writer.writeLine(reader.read())
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}