fun main() {
    val (base, exponent, divisor) = readln().split(" ").map(String::toBigInteger)
    println(base.modPow(exponent, divisor))
}