

fun findMinimumChange(v: IntArray): Long {
    var total: Long = 1

    for (c in v.sorted()) {
        if (c > total) {
            return total
        }
        else {
            total += c
        }
    }

    return total
}