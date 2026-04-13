fun main() {
    val size = readln().toInt()
    println(
        readln().split(" ")
            .map(String::toInt)
            .sorted()
            .foldIndexed(0) { index, acc, time -> acc + time * (size - index) }
    )
}