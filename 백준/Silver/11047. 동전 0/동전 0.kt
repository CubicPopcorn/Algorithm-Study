fun main() {
    val (coinCount, goal) = readln().split(" ").map(String::toInt)
    val coinValues = List(coinCount) { readln().toInt() }
    val descendingValues = coinValues.asReversed()
    var remaining = goal
    var coins = 0
    for (value in descendingValues) {
        coins += remaining / value
        remaining %= value
    }
    println(coins)
}