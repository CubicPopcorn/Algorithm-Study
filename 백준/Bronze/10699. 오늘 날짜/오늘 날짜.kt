import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun main() {
    val seoulNow = Instant.now().atZone(ZoneId.of("Asia/Seoul"))
    println(seoulNow.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")))
}