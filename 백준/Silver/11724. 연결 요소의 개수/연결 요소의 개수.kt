import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (nodeCount, edgeCount) = reader.readLine().split(" ").map(String::toInt)
        val nodeMap = mutableMapOf<Int, MutableList<Int>>()
        repeat(edgeCount) {
            val (a, b) = reader.readLine().split(" ").map(String::toInt)
            nodeMap.computeIfAbsent(a, ::ArrayList).add(b)
            nodeMap.computeIfAbsent(b, ::ArrayList).add(a)
        }

        val remainingNodes = nodeMap.keys
        var count = nodeCount - remainingNodes.size
        while (remainingNodes.isNotEmpty()) {
            val startNode = remainingNodes.first()
            val nodeQueue = ArrayDeque<Int>()
            nodeQueue.add(startNode)
            while (nodeQueue.isNotEmpty()) {
                for (i in nodeQueue.indices) {
                    val node = nodeQueue.removeFirst()
                    if (node !in remainingNodes) continue
                    for (connected in nodeMap[node]!!) {
                        nodeQueue.add(connected)
                    }
                    nodeMap.remove(node)
                }
            }
            count++
        }
        writer.writeLine(count)
    }
}

fun Writer.writeLine(obj: Any?) {
    this.appendLine(obj?.toString())
}