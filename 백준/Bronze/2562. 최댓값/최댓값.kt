import java.io.Writer

fun main() = System.`in`.bufferedReader().useLines { lines ->
    System.out.bufferedWriter().use { writer ->
        var max = 0
        var maxIndex = -1
        lines.map(String::toInt).forEachIndexed { index, num ->
            if (num > max) {
                max = num
                maxIndex = index
            }
        }
        writer.writeLine(max)
        writer.writeLine(maxIndex + 1)
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}