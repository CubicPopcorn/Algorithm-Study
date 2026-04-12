fun main() {
    val goal = readln().toInt()
    for (fives in goal / 5 downTo 0) {
        val threes = (goal - fives * 5) / 3
        if (threes * 3 + fives * 5 == goal) {
            println(threes + fives)
            return
        }
    }
    println(-1)
}