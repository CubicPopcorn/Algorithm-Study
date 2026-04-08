fun main() {
    val input = readln().trim()
    if (input.isEmpty()) {
        println(0)
    } else {
        println(input.count { it == ' ' } + 1)
    }
}