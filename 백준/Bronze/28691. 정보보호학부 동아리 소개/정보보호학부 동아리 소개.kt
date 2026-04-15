fun main() {
    println(
        when (readln()) {
            "M" -> "MatKor"
            "W" -> "WiCys"
            "C" -> "CyKor"
            "A" -> "AlKor"
            else -> "\$clear"
        }
    )
}