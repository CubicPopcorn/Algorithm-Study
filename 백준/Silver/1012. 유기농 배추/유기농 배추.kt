import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        repeat(reader.readLine().toInt()) {
            val (width, height, cropCount) = reader.readLine().split(" ").map(String::toInt)
            val field = Array(width) { Array(height) { FieldState.EMPTY } }
            val offsets = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
            repeat(cropCount) {
                val (x, y) = reader.readLine().split(" ").map(String::toInt)
                field[x][y] = FieldState.PLANTED
            }
            fun spreadImmunity(x: Int, y: Int) {
                for (offset in offsets) {
                    val neighborX = x + offset.first
                    val neighborY = y + offset.second
                    if (neighborX !in 0..<width || neighborY !in 0..<height) continue
                    val neighbor = field[neighborX][neighborY]
                    if (neighbor == FieldState.PLANTED) {
                        field[neighborX][neighborY] = FieldState.BRANCH
                        spreadImmunity(neighborX, neighborY)
                    }
                }
            }
            for (y in 0..<height) {
                for (x in 0..<width) {
                    if (field[x][y] == FieldState.PLANTED) {
                        field[x][y] = FieldState.ROOT
                        spreadImmunity(x, y)
                    }
                }
            }
            writer.writeLine(field.fold(0) { acc, column -> acc + column.count { it == FieldState.ROOT } })
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}

enum class FieldState {
    EMPTY,
    PLANTED,
    ROOT,
    BRANCH
}