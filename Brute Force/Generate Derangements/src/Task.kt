
// Write additional classes and functions here
fun generateDerangements(n: Int, prefix: Derangement = Derangement(intArrayOf())): List<Derangement> {
    // base case: we are done
    if (prefix.length() == n) {
        return listOf(prefix)
    }

    val result = emptyList<Derangement>().toMutableList()

    // find each valid prefix, then generate derangements for that prefix
    (0 until n)
        .asSequence()
        .filter { it !in prefix && it != prefix.length() }
        .forEach { result.addAll(generateDerangements(n, prefix.append(it))) }

    return result
}
