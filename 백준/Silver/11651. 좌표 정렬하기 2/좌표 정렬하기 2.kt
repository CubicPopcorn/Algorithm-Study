import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val points = List(reader.readLine().toInt()) {
            val (x, y) = reader.readLine().split(" ").map(String::toInt)
            Point(x, y)
        }
        val sorted = points.sortedWith(compareBy({ it.y }, { it.x }))
        sorted.forEach {
            writer.writeLine("${it.x} ${it.y}")
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}

data class Point(val x: Int, val y: Int)