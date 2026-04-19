class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val documents = priorities.mapIndexed { index, priority -> Document(id = index, priority = priority) }
        val queue = ArrayDeque(documents)
        val remainingByPriority = documents.groupingBy { it.priority }.eachCount().toSortedMap()
        do {
            val document = queue.removeFirst()
            if (document.priority == remainingByPriority.lastKey()) {
                if (document.id == location) {
                    return documents.size - queue.size
                }
                remainingByPriority[document.priority] = remainingByPriority[document.priority]!! - 1
                if (remainingByPriority[document.priority]!! <= 0) {
                    remainingByPriority.remove(document.priority)
                }
            } else {
                queue.addLast(document)
            }
        } while (queue.isNotEmpty())
        error("도달할 수 없음")
    }
}

data class Document(val id: Int, val priority: Int)