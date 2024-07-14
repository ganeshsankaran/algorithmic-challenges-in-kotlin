
class CountBlocksOfOnesWithUpdates(seq: CharSequence) {
    // write required fields and methods here
    private var seq = seq
        .map { it.digitToInt() }
        .toMutableList()

    private var ones: Int? = null
    private var blocks: Int? = null

    fun countOnes(): Int {
        if (ones == null) {
            ones = seq.count {it == 1}
        }
        return ones!!
    }

    fun countBlocksOfOnes(): Int {
        if (blocks == null) {
            var ct = if (seq.firstOrNull() == 1) 1 else 0
            ct += (1 until seq.size)
                .count { seq[it] == 1 && seq[it - 1] == 0 }
            blocks = ct
        }
        return blocks!!
    }

    fun flip(index: Int) {
        // update number of ones
        ones = when (seq[index]) {
            0 -> ones?.plus(1)
            else -> ones?.minus(1)
        }

        // edge case
        // singleton list
        if (seq.size == 1) {
            blocks = when (seq[index]) {
                0 -> 1
                else -> 0
            }
        }

        // pad the start and end if applicable.
        // that way we do not have to do the edge case
        // where we update the first or last element
        val prev = if (index == 0) 0 else seq[index - 1]
        val next = if (index == seq.size - 1) 0 else seq[index + 1]

        // general case: 000->010, 010->000, 101->111, 111->101
        if (prev == 0 && next == 0) {
            blocks = when (seq[index]) {
                0 -> blocks?.plus(1)
                else -> blocks?.minus(1)
            }
        }
        else if (prev == 1 && next == 1) {
            blocks = when (seq[index]) {
                0 -> blocks?.minus(1)
                else -> blocks?.plus(1)
            }
        }

        seq[index] = 1 - seq[index]
    }
}
