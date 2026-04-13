import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (sizeA, sizeB) = reader.readLine().split(" ").map(String::toInt)
        val a = buildSet {
            repeat(sizeA) {
                add(reader.readLine())
            }
        }
        val b = buildSet {
            repeat(sizeB) {
                add(reader.readLine())
            }
        }
        val union = a.intersect(b).toSortedSet()
        writer.writeLine(union.size)
        union.forEach(writer::writeLine)
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}