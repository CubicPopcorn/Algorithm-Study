fun main() {
    println(
        readln().split("-")
            .map {
                it.split("+")
                    .map(String::toInt)
                    .fold(0, Int::plus)
            }
            .reduce(Int::minus)
    )
}