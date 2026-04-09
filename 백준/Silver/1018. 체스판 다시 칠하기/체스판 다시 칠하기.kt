import kotlin.math.min

fun main() {
    val (height, width) = readln().split(" ").map(String::toInt)
    val matrix = List(height) { y ->
        readln().mapIndexed { x, char ->
            var color = Color.fromChar(char)
            if ((x + y) % 2 == 0) color = color.flipped
            return@mapIndexed color
        }
    }
    var lowestDiff = Int.MAX_VALUE
    for (row in 0..height - 8) {
        for (column in 0..width - 8) {
            val subMatrix = List(8) { index -> matrix[row + index].subList(column, column + 8) }
            val diffA = subMatrix.flatten().count { it == Color.BLACK }
            val diffB = subMatrix.flatten().count { it == Color.WHITE }
            lowestDiff = min(lowestDiff, min(diffA, diffB))
        }
    }
    println(lowestDiff)
}

enum class Color {
    BLACK, WHITE;

    val flipped
        get() = if (this == BLACK) WHITE else BLACK

    companion object {
        fun fromChar(char: Char) = if (char == 'B') BLACK else WHITE
    }
}