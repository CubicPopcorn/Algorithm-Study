fun main() {
    val (userCount, relationCount) = readln().split(" ").map(String::toInt)
    val allUsers = List(userCount) { User(it + 1) }
    repeat(relationCount) {
        val (a, b) = readln().split(" ").map(String::toInt)
        val userA = allUsers[a - 1]
        val userB = allUsers[b - 1]
        userA.friends.add(userB)
        userB.friends.add(userA)
    }
    val baconNumberMap = sortedMapOf<User, Int>()
    allUsers.forEach { interestedUser ->
        val depthMap = mutableMapOf<User, Int>()
        depthMap[interestedUser] = 0
        var users = interestedUser.friends.toMutableSet()
        var nextUsers = mutableSetOf<User>()
        var depth = 1
        while (depthMap.keys.size < userCount) {
            for (user in users) {
                if (user in depthMap.keys) continue
                depthMap[user] = depth
                nextUsers.addAll(user.friends)
            }
            users = nextUsers
            nextUsers = mutableSetOf()
            depth++
        }
        baconNumberMap[interestedUser] = depthMap.values.sum()
    }
    val result = baconNumberMap.minBy { (_, baconNumber) -> baconNumber }
    println(result.key.id)
}

data class User(val id: Int) : Comparable<User> {
    val friends = mutableSetOf<User>()

    override fun compareTo(other: User) = compareValuesBy(this, other) { it.id }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        return id == other.id
    }

    override fun hashCode() = id
}