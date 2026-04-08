fun main() {
    repeat(readln().toInt()) {
        val history = readln()
        var scoreOnCorrectAnswer = 1
        var score = 0
        history.forEach { char ->
            if (char == 'O') {
                score += scoreOnCorrectAnswer
                scoreOnCorrectAnswer++
            } else {
                scoreOnCorrectAnswer = 1
            }
        }
        println(score)
    }
}