import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val set = mutableSetOf<Int>()
        repeat(reader.readLine().toInt()) {
            val input = reader.readLine().split(" ")
            when (input[0]) {
                "add" -> set.add(input[1].toInt())
                "remove" -> set.remove(input[1].toInt())
                "check" -> writer.writeLine(if (set.contains(input[1].toInt())) 1 else 0)
                "toggle" -> {
                    val number = input[1].toInt()
                    if (set.contains(number)) {
                        set.remove(number)
                    } else {
                        set.add(number)
                    }
                }
                "all" -> set.addAll(1..20)
                "empty" -> set.clear()
            }
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}