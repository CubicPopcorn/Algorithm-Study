import java.io.Writer
import kotlin.math.max

const val START = 2
const val OBSTRUCTED = 0
const val PATH = 1

const val NOT_ENCOUNTERED = -2
const val QUEUED = -3

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (height, width) = reader.readLine().split(" ").map(String::toInt)
        val map = List(height) { reader.readLine().split(" ").map(String::toInt) }

        val result = Array(height) { IntArray(width) { NOT_ENCOUNTERED } }
        var startLocationInit: Pair<Int, Int>? = null
        for (row in 0..<height) {
            for (column in 0..<width) {
                val cell = map[row][column]
                when (cell) {
                    START -> startLocationInit = Pair(row, column)
                    OBSTRUCTED -> result[row][column] = 0
                }
            }
        }
        val startLocation = startLocationInit ?: error("Invalid Input")

        val posQueue = ArrayDeque<Pair<Int, Int>>()
        posQueue.add(startLocation)
        var distance = 0
        while (posQueue.isNotEmpty()) {
            val queueSize = posQueue.size
            for (i in 0..<queueSize) {
                val (row, column) = posQueue.removeFirst()
                result[row][column] = distance
                fun visitNeighbor(adjRow: Int, adjCol: Int) {
                    if (adjRow in 0..<height && adjCol in 0..<width
                        && map[adjRow][adjCol] == PATH
                        && result[adjRow][adjCol] == NOT_ENCOUNTERED) {
                        result[adjRow][adjCol] = QUEUED
                        posQueue.addLast(Pair(adjRow, adjCol))
                    }
                }
                visitNeighbor(row + 1, column)
                visitNeighbor(row - 1, column)
                visitNeighbor(row, column + 1)
                visitNeighbor(row, column - 1)
            }
            distance++
        }
        result.forEach { row ->
            writer.write(max(row.first(), -1).toString())
            for (i in 1..row.lastIndex) {
                writer.write(" ${max(row[i], -1)}")
            }
            writer.writeLine()
        }
    }
}

fun Writer.writeLine(obj: Any? = "") {
    this.appendLine(obj?.toString())
}