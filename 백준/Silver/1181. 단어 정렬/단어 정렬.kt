fun main() {
    val words = List(readln().toInt()) { readln() }
    val result = words.toSortedSet { a, b ->
        if (a.length != b.length) a.length.compareTo(b.length)
        else a.compareTo(b)
    }.joinToString(separator = "\n")
    println(result)
}