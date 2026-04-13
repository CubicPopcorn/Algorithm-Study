import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (pokemonCount, problemCount) = reader.readLine().split(" ").map(String::toInt)
        val pokemonList = List(pokemonCount) { reader.readLine() }
        val nameToId = mapOf(*pokemonList.mapIndexed { index, name -> name to index + 1 }.toTypedArray())
        repeat(problemCount) {
            val input = reader.readLine()
            val question = input.toIntOrNull() ?: input
            when (question) {
                is Int -> writer.writeLine(pokemonList[question - 1])
                is String -> writer.writeLine(nameToId[question])
            }
        }
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}