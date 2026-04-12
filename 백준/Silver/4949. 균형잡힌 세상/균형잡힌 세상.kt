import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        mainLoop@while (true) {
            val string = reader.readLine()
            if (string == ".") break
            val openingCharMap = mapOf(')' to '(', ']' to '[')
            val stack = ArrayDeque<Char>()
            for (char in string) {
                when (char) {
                    '(', '[' -> stack.addLast(char)
                    ')', ']' -> if (stack.isEmpty() || stack.removeLast() != openingCharMap[char]) {
                        writer.writeLine("no")
                        continue@mainLoop
                    }
                }
            }
            writer.writeLine(if (stack.isEmpty()) "yes" else "no")
        }
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}