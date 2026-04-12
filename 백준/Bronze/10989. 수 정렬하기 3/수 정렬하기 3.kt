import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val inputSize = reader.readLine().toInt()
        val frequency = IntArray(10000)
        repeat(inputSize) {
            frequency[reader.readLine().toInt() - 1]++
        }
        frequency.forEachIndexed { index, freq ->
            if (freq == 0) return@forEachIndexed
            repeat(freq) {
                writer.writeLine(index + 1)
            }
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}