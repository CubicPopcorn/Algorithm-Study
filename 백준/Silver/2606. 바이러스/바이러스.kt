fun main() {
    val computerCount = readln().toInt()
    val computers = List(computerCount) { Computer(it + 1) }
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map(String::toInt)
        val computerA = computers[a - 1]
        val computerB = computers[b - 1]
        computerA.connections.add(computerB)
        computerB.connections.add(computerA)
    }

    val infectedComputers = mutableSetOf(computers[0])
    fun spreadInfection(computer: Computer) {
        computer.connections.forEach { connected ->
            if (connected !in infectedComputers) {
                infectedComputers.add(connected)
                spreadInfection(connected)
            }
        }
    }
    spreadInfection(computers[0])
    println(infectedComputers.size - 1)
}

class Computer(val id: Int) {
    val connections = mutableSetOf<Computer>()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Computer) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}