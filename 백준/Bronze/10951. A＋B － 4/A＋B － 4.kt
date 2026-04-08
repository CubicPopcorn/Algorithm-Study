import java.io.Writer

fun main() = System.`in`.bufferedReader().useLines { lines ->
    System.out.bufferedWriter().use { writer ->
        lines.forEach { line ->
            val (a, b) = line.split(" ").map(String::toInt)
            writer.writeLine(a + b)
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}