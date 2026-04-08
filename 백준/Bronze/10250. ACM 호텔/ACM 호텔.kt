fun main() {
    repeat(readln().toInt()) {
        val (height, _, peopleAmount) = readln().split(" ").map(String::toInt)
        println("%d%02d".format((peopleAmount - 1) % height + 1, (peopleAmount - 1) / height + 1))
    }
}