fun main() {
    val (people, step) = readln().split(" ").map(String::toInt)
    val queue = ArrayDeque<Int>(people).apply { addAll(1..people) }
    val order = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        repeat(step - 1) {
            queue.addLast(queue.removeFirst())
        }
        order.add(queue.removeFirst())
    }
    println(order.joinToString(prefix = "<", separator = ", ", postfix = ">"))
}