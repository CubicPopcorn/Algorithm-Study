fun main() {
    val (otherPrice, otherPerformance, price) = readln().split(" ").map(String::toInt)
    val performance = otherPerformance / otherPrice * 3 * price
    println(performance)
}