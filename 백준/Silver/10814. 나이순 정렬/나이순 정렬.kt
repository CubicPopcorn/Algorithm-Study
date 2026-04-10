import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val size = reader.readLine().toInt()
        val members = List(size) {
            val (age, name) = reader.readLine().split(" ")
            Member(age = age.toInt(), name = name)
        }
        writer.writeLine(members.sortedBy { it.age }.joinToString("\n") { "${it.age} ${it.name}" })
    }
}

fun Writer.writeLine(obj: Any) {
    this.appendLine(obj.toString())
}

data class Member(val age: Int, val name: String)