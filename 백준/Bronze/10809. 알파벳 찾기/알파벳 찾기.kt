fun main() {
    val word = readln()
    val firstIndex = IntArray('z'.code - 'a'.code + 1) { -1 }
    word.forEachIndexed { index, char ->
        val alphabetIndex = char.code - 'a'.code
        if (firstIndex[alphabetIndex] == -1) {
            firstIndex[alphabetIndex] = index
        }
    }
    println(firstIndex.joinToString(separator = " "))
}