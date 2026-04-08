fun main() {
    val result = readln().split(" ").map(String::toBigInteger).reduce { a, b -> a + b }
    println(result)
}