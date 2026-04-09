fun main() {
    for (i in 1..readln().toInt()) {
        val initialHeads = readln().toInt()
        val actions = readln()
        println("Data Set $i:")
        println(initialHeads + actions.count { it == 'c' } - actions.count { it == 'b' })
        println()
    }
}