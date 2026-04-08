import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val alphabet = reader.read().toChar()
        if (alphabet == 'F') {
            writer.writeLine(0.0)
            return
        }
        val base = 4.0 - (alphabet.code - 'A'.code)
        val modifier = reader.read().toChar()
        val result = base + when (modifier) {
            '+' -> 0.3
            '-' -> -0.3
            else -> 0.0
        }
        writer.writeLine(result)
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}