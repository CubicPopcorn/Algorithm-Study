import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        repeat(reader.readLine().toInt()) {
            val (r, string) = reader.readLine().split(" ")
            string.forEach { char ->
                writer.write(char.toString().repeat(r.toInt()))
            }
            writer.appendLine()
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}