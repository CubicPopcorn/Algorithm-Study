fun main() {
    repeat(readln().toInt()) {
        val input = readln()
        println(
            if (input[input.lastIndex / 2] == input[input.lastIndex / 2 + 1]) "Do-it" else "Do-it-Not"
        )
    }
}