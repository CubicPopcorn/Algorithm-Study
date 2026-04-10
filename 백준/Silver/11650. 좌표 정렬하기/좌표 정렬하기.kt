import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val list = List(reader.readLine().toInt()) {
            val (x, y) = reader.readLine().split(" ").map(String::toInt)
            Point(x, y)
        }
        writer.writeLine(list.sorted().joinToString("\n") { "${it.x} ${it.y}" })
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}

data class Point(val x: Int, val y: Int): Comparable<Point> {
    override fun compareTo(other: Point): Int = compareValuesBy(this, other, { it.x }, { it.y })
}