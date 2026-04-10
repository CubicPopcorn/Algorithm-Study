fun main() {
    repeat(readln().toInt()) {
        val input = readln()
        var openedBrackets = 0
        input.forEach {
            if (it == '(') {
                openedBrackets++
            } else if (--openedBrackets < 0) {
                println("NO")
                return@repeat
            }
        }
        println(if (openedBrackets == 0) "YES" else "NO")
    }
}