
fun distinctSummands(n: Long): List<Long> {
    val summands = emptyList<Long>().toMutableList()
    var sum = 0L

    for (i in 1..n) {
        // we cannot add i and (i + 1),
        // so just add the remaining
        if (n - sum <= 2 * i) {
            summands.add(n - sum)
            break
        }
        sum += i
        summands.add(i)
    }

    return summands
}
