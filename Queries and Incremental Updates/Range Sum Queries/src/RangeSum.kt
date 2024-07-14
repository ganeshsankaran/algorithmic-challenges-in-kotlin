class RangeSum(a: IntArray) {
    // Implement additional fields and method here
    val runningSums = MutableList<Long>(a.size + 1) {0}

    init {
        // default runningReduce causes OOM
        for (i in 1..a.size) {
            runningSums[i] = runningSums[i - 1] + a[i - 1].toLong()
        }
    }

    fun getSum(left: Int, right: Int): Long =
        runningSums[right] - runningSums[left]

}

