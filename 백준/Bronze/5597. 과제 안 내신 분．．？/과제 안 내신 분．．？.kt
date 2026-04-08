import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val submitStates = BooleanArray(30)
        repeat(28) {
            val index = reader.readLine().toInt() - 1
            submitStates[index] = true
        }
        submitStates.forEachIndexed { index, submitted ->
            if (!submitted) writer.writeLine(index + 1)
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}