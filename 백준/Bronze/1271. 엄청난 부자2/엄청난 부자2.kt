import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (money, creatures) = reader.readLine().split(" ").map(String::toBigInteger)
        writer.writeLine(money / creatures)
        writer.writeLine(money % creatures)
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}