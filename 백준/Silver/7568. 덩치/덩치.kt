
import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val people = List(reader.readLine().toInt()) {
            val (height, weight) = reader.readLine().split(" ").map(String::toInt)
            Person(height = height, weight = weight)
        }
        writer.writeLine(
            people.joinToString(separator = " ") { person -> people.count { it.height > person.height && it.weight > person.weight }.plus(1).toString() }
        )
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}

data class Person(val height: Int, val weight: Int)