fun main() {
    val (step, fall, goal) = readln().split(" ").map(String::toInt)
    val stepsBeforeLast = (goal - step) / (step - fall) + if ((goal - step) % (step - fall) != 0) 1 else 0
    println(stepsBeforeLast + 1)
}