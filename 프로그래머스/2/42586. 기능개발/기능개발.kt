class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val progressQueue = ArrayDeque<Int>(10)
        for (initialProgress in progresses) {
            progressQueue.addLast(initialProgress)
        }
        val result = sortedMapOf<Int, Int>()
        var time = 0
        fun checkProgress() {
            val initialProgress = progressQueue.firstOrNull() ?: return
            val featureIndex = progresses.size - progressQueue.size
            val addedProgress = time * speeds[featureIndex]
            if (initialProgress + addedProgress >= 100) {
                progressQueue.removeFirst()
                result[time] = result.getOrDefault(time, 0) + 1
                checkProgress()
            } else {
                time++
            }
        }
        
        while (progressQueue.isNotEmpty()) {
            checkProgress()
        }
        return result.values.toIntArray()
    }
}