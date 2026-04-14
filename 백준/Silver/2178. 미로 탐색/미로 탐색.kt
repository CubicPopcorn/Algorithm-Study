import java.util.*

fun main() {
    val (height, width) = readln().split(" ").map(String::toInt)
    val maze = List(height) { row ->
        readln().mapIndexed { column, char ->
            val h = if (char == '0') 99999 else ((width - 1) - column) + ((height - 1) - row)
            Cell(row = row, column = column, reachCost = 99999, heuristic = h)
        }
    }
    val start = maze[0][0]
    start.reachCost = 0
    val destination = maze[height - 1][width - 1]

    val priorityQueue = PriorityQueue<Cell>(compareBy { it.reachCost + it.heuristic })
    priorityQueue.add(start)
    val offsets = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
    while (!destination.visited) {
        val cell = priorityQueue.poll()
        cell.visited = true
        for (offset in offsets) {
            val (rowOffset, colOffset) = offset
            val adjacentRow = cell.row + rowOffset
            val adjacentCol = cell.column + colOffset
            if (adjacentRow !in 0..<height || adjacentCol !in 0..<width) continue
            val adjacent = maze[adjacentRow][adjacentCol]
            if (!adjacent.visited && cell.reachCost + 1 < adjacent.reachCost) {
                adjacent.reachCost = cell.reachCost + 1
                priorityQueue.remove(adjacent)
                priorityQueue.offer(adjacent)
            }
        }
    }
    println(destination.reachCost + 1)
}

class Cell(val row: Int, val column: Int, var reachCost: Int, val heuristic: Int) {
    var visited = false
}