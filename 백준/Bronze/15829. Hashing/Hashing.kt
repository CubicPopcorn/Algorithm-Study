fun main() {
    readln()
    val hash = readln().map { (it.code - 'a'.code + 1).toBigInteger() }
        .foldIndexed(0.toBigInteger()) { index, acc, value ->
            acc + value * 31.toBigInteger().modPow(index.toBigInteger(), 1234567891.toBigInteger())
        } % 123456789.toBigInteger()
    println(hash)
}