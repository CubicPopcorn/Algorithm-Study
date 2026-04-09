fun main() {
    val destination = readln().toInt()
    var layer = 0
    while (true) {
        val cells = 1 + layer * (layer + 1) / 2 * 6
        if (destination <= cells) {
            println(layer + 1)
            break
        }
        layer++
    }
}