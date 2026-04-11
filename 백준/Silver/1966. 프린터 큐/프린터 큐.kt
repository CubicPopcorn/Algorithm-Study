fun main() {
    repeat(readln().toInt()) {
        val (_, interestedId) = parseLine()
        val documents = parseLine().mapIndexed { index, priority -> Document(id = index, priority = priority) }
        val queue = ArrayDeque(documents)
        val remainingByPriority = sortedMapOf<Int, Int>().apply {
            documents.forEach {
                this[it.priority] = this.getOrDefault(it.priority, 0) + 1
            }
        }
        do {
            val document = queue.removeFirst()
            if (document.priority == remainingByPriority.lastKey()) {
                if (document.id == interestedId) {
                    println(documents.size - queue.size)
                    return@repeat
                }
                remainingByPriority[document.priority] = remainingByPriority[document.priority]!! - 1
                if (remainingByPriority[document.priority]!! <= 0) {
                    remainingByPriority.remove(document.priority)
                }
            } else {
                queue.addLast(document)
            }
        } while (queue.isNotEmpty())
    }
}

fun parseLine() = readln().split(" ").map(String::toInt)

data class Document(val id: Int, val priority: Int)