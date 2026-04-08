import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (height, width) = reader.readLine().split(" ").map(String::toInt)
        val matrix = Array(height) { IntArray(width) { 0 } }
        repeat(2) {
            for (i in 0..<height) {
                val row = reader.readLine().split(" ").map(String::toInt)
                for (j in 0..<width) {
                    matrix[i][j] += row[j]
                }
            }
        }
        writer.writeLine(matrix.joinToString(separator = "\n") { it.joinToString(separator = " ")})
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}