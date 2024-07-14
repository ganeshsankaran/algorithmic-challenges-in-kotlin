
fun <T : Comparable<T>> getMedian(a: List<T>, b: List<T>): T {
    assert(a.size == b.size)

    var l = -1
    var r = a.size
    val n = a.size

    while (l < r - 1) {
        val m = (l + r) / 2
        if (a[m] < b[n - m - 1]) {
            l = m
        } else {
            r = m
        }
    }

    return if (l == -1) { // first[0] > second[k - 1] => all second < first
        b[n - 1]
    } else if (r == n) { // first[k - 1] < second[0] => all second > first
        a[n - 1]
    } else {
        maxOf(a[l], b[n - r - 1])
    }

}
