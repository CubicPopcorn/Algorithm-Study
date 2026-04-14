import java.io.Writer

const val NOT_PRESENT = -1
const val UNRIPENED = 0
const val RIPENED = 1

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (width, depth, height) = reader.readLine().split(" ").map(String::toInt)
        val tomatoes = Array(height) { Array(depth) { reader.readLine().split(" ").map(String::toInt).toIntArray() } }
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        for (floor in 0..<height) {
            for (row in 0..<depth) {
                for (column in 0..<width) {
                    val tomato = tomatoes[floor][row][column]
                    if (tomato == RIPENED) queue.add(Triple(floor, row, column))
                }
            }
        }
        val offsets = listOf(
            Triple(1, 0, 0),
            Triple(-1, 0, 0),
            Triple(0, 1, 0),
            Triple(0, -1, 0),
            Triple(0, 0, 1),
            Triple(0, 0, -1),
        )
        var day = 0
        while (queue.isNotEmpty()) {
            val currentQueueSize = queue.size
            for (i in 0..<currentQueueSize) {
                val (floor, row, column) = queue.removeFirst()
                for (offset in offsets) {
                    val (floorOffset, rowOffset, columnOffset) = offset
                    val adjFloor = floor + floorOffset
                    val adjRow = row + rowOffset
                    val adjCol = column + columnOffset
                    if (adjFloor in tomatoes.indices
                        && adjRow in tomatoes[0].indices
                        && adjCol in tomatoes[0][0].indices
                        && tomatoes[adjFloor][adjRow][adjCol] == UNRIPENED) {
                        tomatoes[adjFloor][adjRow][adjCol] = RIPENED
                        queue.addLast(Triple(adjFloor, adjRow, adjCol))
                    }
                }
            }
            day++
        }
        val containUnripened = tomatoes.any { floor -> floor.any { row -> row.contains(UNRIPENED) } }
        writer.writeLine(if (!containUnripened) day - 1 else -1)
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}