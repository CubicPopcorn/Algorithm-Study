fun main() {
    val target = readln().toInt()
    for (i in 1..target) {
        val digitSum = i + i.toString().map { it.code - '0'.code }.sum()
        if (digitSum == target) {
            println(i)
            return
        }
    }
    println(0)
}