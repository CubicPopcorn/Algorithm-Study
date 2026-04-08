fun main() {
    val result = readln().map { char ->
        if (char.isUpperCase()) char.lowercaseChar()
        else char.uppercaseChar()
    }.joinToString(separator = "")
    println(result)
}