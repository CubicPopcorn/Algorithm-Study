fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val multiplied = (a * b * c).toString()
    val frequency = IntArray(10)
    multiplied.forEach { char ->
        frequency[char.code - '0'.code]++
    }
    println(frequency.joinToString(separator = "\n"))
}