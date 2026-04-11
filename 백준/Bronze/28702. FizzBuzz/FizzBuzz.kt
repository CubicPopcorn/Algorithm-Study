fun main() {
    val numbers = List(3) { readln().toIntOrNull() }
    numbers.asReversed().forEachIndexed { passedInputs, numberOrNull ->
        val number = numberOrNull ?: return@forEachIndexed
        val next = number + passedInputs + 1
        println(buildString {
            if (next % 3 == 0) append("Fizz")
            if (next % 5 == 0) append("Buzz")
            if (this.isEmpty()) append(next)
        })
        return
    }
}