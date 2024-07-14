
class CountOnesWithUpdates(seq: CharSequence)  {
    // create required fields and methods here
    private var seq = seq
        .map { it.digitToInt() }
        .toMutableList()

    private var ones: Int? = null

    fun countOnes() : Int {
        if (ones == null) {
            ones = seq.count {it == 1}
        }
        return ones!!
    }

    fun flip(index: Int) {
        when (seq[index]) {
            0 -> ones = ones?.inc()
            1 -> ones = ones?.dec()
        }
        seq[index] = 1 - seq[index]
    }
}
