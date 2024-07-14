// l and r may not actually be in the array
fun countInRange(a: IntArray, l: Int, r: Int): Int {
    val lindex = find(a, l)
    val rindex = find(a, r + 1)
    return rindex - lindex
}

// Write your functions here
fun find(a: IntArray, x: Int): Int {
    val pos = a.binarySearch(x)

    // binarySearch returns inverted insertion point,
    // i.e. (-insertion point - 1)
    return if (pos < 0) {
        -1 * (pos + 1)
    }
    else {
        pos
    }
}
