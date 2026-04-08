fun main() {
    val (a, b) = readln().split(" ").map(String::toInt)
    println(
        when {
            a > b -> ">"
            a < b -> "<"
            else -> "=="
        }
    )
}