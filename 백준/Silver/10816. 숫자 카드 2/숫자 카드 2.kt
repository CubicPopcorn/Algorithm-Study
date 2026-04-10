fun main() {
    val cards = HashMap<Int, Int>(readln().toInt())
    readln().split(" ").map(String::toInt).forEach {
        cards[it] = cards.getOrDefault(it, 0) + 1
    }
    readln()
    println(
        readln().split(" ").joinToString(" ") { cards.getOrDefault(it.toInt(), 0).toString() }
    )
}