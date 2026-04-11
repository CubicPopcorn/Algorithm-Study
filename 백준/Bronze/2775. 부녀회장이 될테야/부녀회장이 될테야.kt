fun main() {
    repeat(readln().toInt()) {
        val floor = readln().toInt()
        val room = readln().toInt()
        val population = Array(floor + 1) { IntArray(room) }
        for (i in 0..<room) {
            population[0][i] = i + 1
        }
        for (i in 0..floor) {
            population[i][0] = 1
        }
        for (y in 1..floor) {
            for (x in 1..<room) {
                population[y][x] = population[y - 1][x] + population[y][x - 1]
            }
        }
        println(population[floor][room - 1])
    }
}