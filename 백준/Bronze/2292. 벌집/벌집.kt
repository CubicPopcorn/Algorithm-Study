fun main() {
    val destination = readln().toInt()
    var cells = 1
    for (i in 0..Int.MAX_VALUE) {
        cells += i * 6
        if (destination <= cells) {
            println(i + 1)
            break
        }
    }
}