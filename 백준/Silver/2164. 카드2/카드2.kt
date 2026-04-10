fun main() {
    val input = readln().toInt()
    val queue = ArrayDeque<Int>(input)
    queue.addAll(1..input)
    while (queue.size != 1) {
        queue.removeFirst()
        queue.addLast(queue.first())
        queue.removeFirst()
    }
    println(queue.first())
}