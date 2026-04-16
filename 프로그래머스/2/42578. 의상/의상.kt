class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val clothMap = clothes.groupBy({ it[1] }, { it[0] })
        val combinationCount = clothMap.values.fold(1) { acc, gears -> acc * (gears.size + 1) }
        return combinationCount - 1
    }
}