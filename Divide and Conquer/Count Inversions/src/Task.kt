// Implement additional functions and classes here
class Counter<in T : Comparable<T>>(a: List<T>) {
    private val a = MutableList(a.size) { a[it] to it } // keep track of element and original index
    private val buf = mutableListOf<Pair<T, Int>>() // mergesort buffer
    private val result = IntArray(a.size)

    private fun mergeSort(l: Int, r: Int) {
        if (l + 1 >= r) return

        val m = (l + r) / 2

        mergeSort(l, m)
        mergeSort(m, r)

        var i = l
        var j = m

        while (i < m || j < r) {
            // not an inversion
            if (j >= r || (i < m && a[i].first <= a[j].first)) {
                buf.add(a[i])
                i++
            }
            // inversion
            else {
                result[a[j].second] += m - i // add inversions
                buf.add(a[j])
                j++
            }
        }

        // sort left part of the array
        for (i in 0 until buf.size) {
            a[i + l] = buf[i]
        }

        buf.clear()
    }

    fun count(): IntArray {
        mergeSort(0, a.size)
        return result
    }
}

fun <T : Comparable<T>> findInversions(a: List<T>): IntArray = Counter(a).count()
