class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val truckQueue = ArrayDeque<Truck>(truck_weights.size)
        truck_weights.mapTo(truckQueue) { Truck(it, 0) }
        var elapsedTime = 0
        val bridge = mutableSetOf<Truck>()
        var weightOnBridge  = 0
        do {
            val iterator = bridge.iterator()
            while (iterator.hasNext()) {
                val truck = iterator.next()
                if (++truck.position >= bridge_length) {
                    iterator.remove()
                    weightOnBridge -= truck.weight
                }
            }
            val nextTruck = truckQueue.firstOrNull()
            if (nextTruck != null && nextTruck.weight + weightOnBridge <= weight) {
                truckQueue.removeFirst()
                weightOnBridge += nextTruck.weight
                bridge.add(nextTruck)
            }
            elapsedTime++
        } while (bridge.isNotEmpty())
        return elapsedTime
    }
}

data class Truck(val weight: Int, var position: Int)