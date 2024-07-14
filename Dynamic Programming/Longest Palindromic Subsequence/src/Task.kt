private class LongestPalindromicSubsequenceFinder(private val seq: CharSequence) {
    val T = Array(seq.length) { IntArray(seq.length) { -1 } }

    // top down DP
    private fun helper(left: Int, right: Int): Int {
        if (left >= right) return 0
        if (left + 1 == right) return 1

        if (T[left][right - 1] != -1) {
            return T[left][right - 1]
        }

        var result = maxOf(
            helper(left + 1, right),
            helper(left, right - 1)
        )

        if (seq[left] == seq[right - 1]) {
            result = maxOf(
                result,
                helper(left + 1, right - 1) + 2
            )
        }

        T[left][right - 1] = result

        return result
    }

    private fun getLongest(left: Int, right: Int, subSeq: Appendable) {
        if (left >= right) return
        if (left + 1 == right) {
            subSeq.append(seq[left])
            return
        }

        when (helper(left, right)) {
            helper(left + 1, right) -> getLongest(left + 1, right, subSeq)
            helper(left, right - 1) -> getLongest(left, right - 1, subSeq)
            // length == calculateLongest(left + 1, right - 1) + 2
            else -> {
                subSeq.append(seq[left])
                getLongest(left + 1, right - 1, subSeq)
                subSeq.append(seq[right - 1])
            }
        }
    }

    fun find(): CharSequence {
        if (seq.isEmpty()) return ""

        val result = StringBuilder()
        getLongest(0, seq.length, result)
        return result
    }
}

fun findLongestPalindromicSubsequence(seq: CharSequence): CharSequence =
    LongestPalindromicSubsequenceFinder(seq).find()