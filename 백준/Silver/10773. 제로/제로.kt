fun main() {
    val stack = ArrayDeque<Int>()
    repeat(readln().toInt()) {
        val number = readln().toInt()
        if (number == 0) {
            stack.removeLast()
        } else{
            stack.add(number)
        }
    }
    println(stack.sum())
}