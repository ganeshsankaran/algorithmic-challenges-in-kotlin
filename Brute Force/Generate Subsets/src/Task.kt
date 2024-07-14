import java.util.BitSet

// I don't really understand this one.
// It doesn't match the pseudocode too well.
private class SubsetGenerator(private val n: Int, private val k: Int) {
    private val subset = BitSet(n)
    private val result = mutableListOf<BitSet>()

    private fun helper(index: Int, used: Int) {
        // we already have a subset of correct size
        if (index == n) {
            result.add(subset.clone() as BitSet)
            return
        }

        // generate subsets with a given number
        if (used < k) {
            subset.set(index)
            helper(index + 1, used + 1)
            subset.set(index, false)
        }

        // generate subsets without that given number
        if (n - index > k - used) {
            helper(index + 1, used)
        }
    }

    fun generate(): List<BitSet> {
        if (result.isEmpty()) {
            helper(0, 0)
        }
        return result
    }
}

fun generateSubsets(n: Int, k: Int): List<BitSet> {
    return SubsetGenerator(n, k).generate()
}
