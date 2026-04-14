import java.io.Writer

const val NOT_PRESENT = -1
const val UNRIPENED = 0
const val RIPENED = 1

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (width, height) = reader.readLine().split(" ").map(String::toInt)
        val tomatoes = Array(height) { reader.readLine().split(" ").map(String::toInt).toIntArray() }
        val queue = ArrayDeque<Pair<Int, Int>>()
        for (row in 0..<height) {
            for (column in 0..<width) {
                val tomato = tomatoes[row][column]
                if (tomato == RIPENED) queue.add(Pair(row, column))
            }
        }
        val offsets = listOf(
            Pair(1, 0),
            Pair(-1, 0),
            Pair(0, 1),
            Pair(0, -1),
        )
        var day = 0
        while (queue.isNotEmpty()) {
            val currentQueueSize = queue.size
            for (i in 0..<currentQueueSize) {
                val (row, column) = queue.removeFirst()
                for (offset in offsets) {
                    val (rowOffset, columnOffset) = offset
                    val adjRow = row + rowOffset
                    val adjCol = column + columnOffset
                    if (adjRow in tomatoes.indices
                        && adjCol in tomatoes[0].indices
                        && tomatoes[adjRow][adjCol] == UNRIPENED) {
                        tomatoes[adjRow][adjCol] = RIPENED
                        queue.addLast(Pair(adjRow, adjCol))
                    }
                }
            }
            day++
        }
        val containUnripened = tomatoes.any { row -> row.contains(UNRIPENED) }
        writer.writeLine(if (!containUnripened) day - 1 else -1)
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}