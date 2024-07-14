

// Implement additional functions and classes if required
fun generatePartitions(n: Int,
                       partition: Partition = Partition(emptyList()),
                       s: Int = 0,
                       m: Int = 1
): List<Partition> {
    // we cannot generate any partitions because
    // running sum is already greater than target
    if (s > n) {
        return emptyList()
    }

    // we have a partition
    if (s == n) {
        return listOf(partition)
    }

    val result = emptyList<Partition>().toMutableList()

    // find partitions, with different terms in order
    for (k in m..(n - s)) {
        result.addAll(generatePartitions(
            n,
            Partition(partition.terms + k),
            s + k,
            maxOf(m, k)
        ))
    }

    return result
}
