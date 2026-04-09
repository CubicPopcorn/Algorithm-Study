import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        reader.readLine()
        val numbers = reader.readLine().split(" ").map(String::toInt).toSortedSet()
        reader.readLine()
        reader.readLine().split(" ")
            .map(String::toInt)
            .forEach {
                writer.writeLine(if (numbers.contains(it)) 1 else 0)
            }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}