import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        repeat(reader.readLine().toInt()) {
            val (a, b) = reader.readLine().split(" ").map(String::toInt)
            writer.writeLine(a + b)
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}