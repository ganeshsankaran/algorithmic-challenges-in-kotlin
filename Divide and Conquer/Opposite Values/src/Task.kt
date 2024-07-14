// find the first one
fun findAnyOccurrenceOf01(str: CharSequence): Int {
    var l = 0
    var r = str.length - 1

    while (l + 1 < r) {
        val mid: Int = (l + r) / 2
        if (str[mid] == '1') {
            // must go from 0 to 1 in first half
            r = mid
        }
        else {
            l = mid
        }
    }

    return l
}