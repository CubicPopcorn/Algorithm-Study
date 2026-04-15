fun main() {
    val (startToHanyang, startToYongdap) = readln().split(" ").map(String::toInt)
    val (hanyangToItbt, yongdapToItbt) = readln().split(" ").map(String::toInt)
    val totalDistanceHanyang = startToHanyang + hanyangToItbt
    val totalDistanceYongdap = startToYongdap + yongdapToItbt
    println(
        when {
            totalDistanceHanyang < totalDistanceYongdap -> "Hanyang Univ."
            totalDistanceHanyang > totalDistanceYongdap -> "Yongdap"
            else -> "Either"
        }
    )
}