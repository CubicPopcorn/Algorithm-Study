fun main() {
    readln()
    val scores = readln().split(" ").map(String::toDouble)
    val max = scores.max()
    println(scores.map { it / max * 100 }.average())
}