fun main() {
    val (numerator, denominator) = readln().split(" ").map(String::toInt)
    println("${denominator - numerator} $denominator")
}