
// write additional code here
class EditDistanceFinder(val first: CharSequence, val second: CharSequence) {
    // distance matrix
    private val D = Array(first.length) {
        IntArray(second.length) { -1 }
    }

    // top-down DP
    private fun helper(i: Int, j: Int): Int {
        if (i == 0 || j == 0) {
            return maxOf(i, j)
        }

        // if we already computed result
        if (D[i - 1][j - 1] != -1) {
            return D[i - 1][j - 1]
        }

        val result = minOf(
            // add or remove a character
            minOf(
                helper(i - 1, j) + 1,
                helper(i, j - 1) + 1
            ),
            // substitute a character. no cost if they are the same
            helper(i - 1, j - 1) + if (first[i - 1] == second[j - 1]) 0 else 1
        )

        D[i - 1][j - 1] = result
        return result
    }

    fun find(): Int = helper(first.length, second.length)
}

fun findEditDistance(first: CharSequence, second: CharSequence): Int =
    EditDistanceFinder(first, second).find()
