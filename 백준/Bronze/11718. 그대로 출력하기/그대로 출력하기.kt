import java.io.Writer

fun main() = System.`in`.bufferedReader().useLines { lines ->
    System.out.bufferedWriter().use { writer ->
        lines.forEach { line ->
            writer.writeLine(line)
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}