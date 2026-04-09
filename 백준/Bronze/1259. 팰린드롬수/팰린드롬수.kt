fun main() {
    while (true) {
        val input = readln()
        if (input == "0") break
        println(
            if (input == input.reversed()) "yes" else "no"
        )
    }
}