fun main() {
    val (height, width) = readln().split(" ").map(String::toInt)
    val map = Array(height) { readln().toCharArray() }
    var maxDepth = 1
    fun visitNeighbor(row: Int, column: Int, passedChars: MutableSet<Char>) {
        if (row !in 0..<height || column !in 0..<width) return
        val char = map[row][column]
        if (char in passedChars) return
        passedChars.add(char)
        maxDepth = maxDepth.coerceAtLeast(passedChars.size)
        visitNeighbor(row + 1, column, passedChars)
        visitNeighbor(row - 1, column, passedChars)
        visitNeighbor(row, column + 1, passedChars)
        visitNeighbor(row, column - 1, passedChars)
        passedChars.remove(char)
    }
    visitNeighbor(0, 0, mutableSetOf())
    println(maxDepth)
}