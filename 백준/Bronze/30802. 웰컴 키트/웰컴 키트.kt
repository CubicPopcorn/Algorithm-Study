fun main() {
    val peopleAmount = readln().toInt()
    val requiredShirtAmounts = readln().split(" ").map(String::toInt)
    val (shirtStackSize, penStackSize) = readln().split(" ").map(String::toInt)
    val deliveries = requiredShirtAmounts.fold(0) { acc, requiredShirtAmount ->
        acc + if (requiredShirtAmount % shirtStackSize == 0) requiredShirtAmount / shirtStackSize
            else requiredShirtAmount / shirtStackSize + 1
    }
    println(deliveries)
    println("${peopleAmount / penStackSize} ${peopleAmount % penStackSize}")
}