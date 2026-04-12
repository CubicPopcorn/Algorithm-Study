import kotlin.math.pow

fun main() {
    val (sizeExponent, rowIndex, columnIndex) = readln().split(" ").map(String::toInt)
    var blockSize = 2.0.pow(sizeExponent - 1).toInt()
    var partitionX = blockSize
    var partitionY = blockSize
    var result = 0
    while (blockSize >= 1) {
        if (columnIndex - partitionX >= 0) {
            partitionX += blockSize / 2
            result += blockSize * blockSize
        } else {
            partitionX -= blockSize / 2
        }
        if (rowIndex - partitionY >= 0) {
            partitionY += blockSize / 2
            result += blockSize * blockSize * 2
        } else {
            partitionY -= blockSize / 2
        }
        blockSize /= 2
    }
    println(result)
}