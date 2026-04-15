fun main() {
    val (songCount, average) = readln().split(" ").map(String::toInt)
    println(songCount * (average - 1) + 1)
}