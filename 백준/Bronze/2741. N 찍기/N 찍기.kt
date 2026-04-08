import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val n = reader.readLine().toInt()
        for (i in 1..n) {
            writer.writeLine(i)
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}