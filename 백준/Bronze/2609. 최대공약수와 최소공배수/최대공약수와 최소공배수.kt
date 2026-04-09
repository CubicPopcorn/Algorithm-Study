fun main() {
    val (a, b) = readln().split(" ").map(String::toInt)
    val gcd = gcd(a, b)
    println(gcd)
    println(a * b / gcd)
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)