import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val n = reader.readLine().toInt()
        val findingChars = ("I" + "OI".repeat(n)).toList()
        reader.readLine().toInt()
        val inputCharList = reader.readLine().toList()
        var count = 0
        for (i in 0..inputCharList.lastIndex - (findingChars.size - 1)) {
            val token = inputCharList.subList(i, i + findingChars.size)
            if (token == findingChars) count++
        }
        writer.writeLine(count)
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}