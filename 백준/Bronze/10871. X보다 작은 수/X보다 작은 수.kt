fun main() {
    val (_, upperLimitExclusive) = readln().split(" ").map(String::toInt)
    val result = readln().split(" ")
        .map(String::toInt)
        .filter { it < upperLimitExclusive }
        .joinToString(separator = " ")
    println(result)
}