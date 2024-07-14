
fun findMaximumAmountOfGold(backpackCapacity: Int, weights: IntArray): Int {
    val T = BooleanArray(backpackCapacity + 1)
    T[0] = true

    for (bar in weights) {
        (backpackCapacity downTo bar)
            .asSequence()
            .filter { T[it - bar] }
            .forEach { T[it] = true }
    }

    var result = backpackCapacity
    while (!T[result]) result--
    return result
}
