fun main() {
    val year = readln().toInt()
    println(
        when {
            year % 400 == 0 -> 1
            year % 100 == 0 -> 0
            year % 4 == 0 -> 1
            else -> 0
        }
    )
}