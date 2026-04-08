fun main() {
    var (hour, minute) = readln().split(" ").map(String::toInt)
    minute -= 45
    if (minute < 0) {
        hour--
        minute += 60
    }
    if (hour < 0) {
        hour += 24
    }
    println("$hour $minute")
}