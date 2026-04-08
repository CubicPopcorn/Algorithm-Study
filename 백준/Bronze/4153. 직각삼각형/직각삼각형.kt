fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map(String::toLong).sorted()
        if (a == 0L && b == 0L && c == 0L) break
        println(
            if (a * a + b * b == c * c) "right" else "wrong"
        )
    }
}