class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val results = IntArray(commands.size)
        commands.forEachIndexed { i, command ->
            val (start, end, ordinal) = command
            val result = array.sliceArray(start - 1 until end).sorted()[ordinal - 1]
            results[i] = result
        }
        return results
    }
}