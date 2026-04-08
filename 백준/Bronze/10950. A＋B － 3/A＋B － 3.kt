fun main() {
    repeat (readln().toInt()) {
        val (a, b) = readln().split(" ").map(String::toInt)
        println(a + b)
    }
}