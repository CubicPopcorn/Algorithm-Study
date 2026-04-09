fun main() {
    val n = readln().toInt()
    var encounteredDoomsNumber = 0
    var i = 666 - 1
    while (encounteredDoomsNumber < n) {
        i++
        if (i.toString().contains("666")) {
            encounteredDoomsNumber++
        }
    }
    println(i)
}