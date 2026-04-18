class Solution {
    fun solution(citations: IntArray): Int {
        val frequencies = citations.asList()
            .groupingBy { it }
            .eachCount()
            .toSortedMap(compareByDescending { it })
        var acc = 0
        val iterator = frequencies.iterator()
        var (citationCount, paperAmount) = iterator.next()
        while (true) {
            val next = if (iterator.hasNext()) iterator.next() else null
            val nextCitationCount = next?.key ?: -1
            acc += paperAmount
            for (i in citationCount downTo nextCitationCount + 1) {
                if (acc >= i) return i
            }
            citationCount = next!!.key
            paperAmount = next.value
        }
    }
}