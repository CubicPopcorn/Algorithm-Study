import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (storedCount, findCount) = reader.readLine().split(" ").map(String::toInt)
        val passwords = HashMap<String, String>(storedCount).apply {
            repeat(storedCount) {
                val (address, password) = reader.readLine().split(" ")
                put(address, password)
            }
        }
        repeat(findCount) {
            val address = reader.readLine()
            writer.writeLine(passwords[address])
        }
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}