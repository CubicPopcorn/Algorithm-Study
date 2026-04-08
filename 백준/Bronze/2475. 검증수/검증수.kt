fun main() {
    val result = readln().split(" ")
        .map(String::toInt)
        .fold(0) { acc, digit -> acc + digit * digit } % 10
    println(result)
}