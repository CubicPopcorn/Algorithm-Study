import java.io.Writer

fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (nodeCount, edgeCount, startNodeId) = reader.readLine().split(" ").map(String::toInt)
        val nodes = List(nodeCount) { Node(id = it + 1) }
        repeat(edgeCount) {
            val (a, b) = reader.readLine().split(" ").map(String::toInt)
            val nodeA = nodes[a - 1]
            val nodeB = nodes[b - 1]
            nodeA.connectedNodes.add(nodeB)
            nodeB.connectedNodes.add(nodeA)
        }
        val visitedNodes = hashSetOf<Node>()
        val startNode = nodes[startNodeId - 1]

        fun visitNodeDFS(node: Node) {
            visitedNodes.add(node)
            if (node != startNode) writer.write(" ${node.id}")
            node.connectedNodes.forEach { connected ->
                if (connected !in visitedNodes) {
                    visitNodeDFS(connected)
                }
            }
        }
        writer.write(startNode.id.toString())
        visitNodeDFS(startNode)

        visitedNodes.clear()
        writer.appendLine()

        visitedNodes.add(startNode)
        writer.write(startNode.id.toString())
        val visitingNodes = linkedSetOf<Node>().apply { addAll(startNode.connectedNodes) }
        val nextNodes = linkedSetOf<Node>()
        while (visitingNodes.isNotEmpty()) {
            visitingNodes.forEach { node ->
                visitedNodes.add(node)
                writer.write(" ${node.id}")
                node.connectedNodes.forEach { connected ->
                    if (connected !in visitedNodes && connected !in visitingNodes) {
                        nextNodes.add(connected)
                    }
                }
            }
            visitingNodes.clear()
            visitingNodes.addAll(nextNodes)
            nextNodes.clear()
        }
    }
}

class Node(val id: Int) : Comparable<Node> {
    val connectedNodes = sortedSetOf<Node>()

    override fun compareTo(other: Node): Int = compareValuesBy(this, other) { it.id }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Node) return false

        return id == other.id
    }

    override fun hashCode(): Int = id
}