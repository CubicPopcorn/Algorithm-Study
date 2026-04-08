fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map(String::toInt)
        if (a == 0 && b == 0) break
        println(a + b)
    }
}