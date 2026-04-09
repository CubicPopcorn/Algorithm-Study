fun main() {
    while (true) {
        val input = readln().toInt()
        if (input == 0) break
        println(input * (input + 1) / 2)
    }
}