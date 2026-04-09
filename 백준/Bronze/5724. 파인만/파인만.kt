fun main() {
    while (true) {
        val size = readln().toInt()
        if (size == 0) break
        val rectangles = size * (size + 1) * (size * 2 + 1) / 6
        println(rectangles)
    }
}