fun minimumSumPath(a: IntArray): Long {
    // n by 2 array
    // T[*][0] -> last jump was 1
    // T[*][1] -> last jump was 2
    val T = Array(a.size) { LongArray(2) { Long.MAX_VALUE } }

    T[0][0] = a[0].toLong()
    T[1][0] = a[0].toLong() + a[1].toLong()

    for (i in 2 until a.size) {
        T[i][0] = T[i - 1].min() + a[i]
        T[i][1] = T[i - 2][0] + a[i]
    }

    return T[a.size - 1].min()
}
