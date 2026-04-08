fun main() {
    val x = readln().toInt()
    val y = readln().toInt()
    val result: Int =
        if (x > 0) {
            if (y > 0) 1 else 4
        } else {
            if (y > 0) 2 else 3
        }
    println(result)
}