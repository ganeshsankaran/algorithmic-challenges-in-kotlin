import kotlin.math.max
import kotlin.math.min

// O(n): scan array once, keep track of first, second max
fun maximumPairwiseProduct(a: IntArray): Long {
    val len = a.size

    if (len == 2) {
        return a[0].toLong() * a[1]
    }

    var max1 = max(a[0], a[1]).toLong()
    var max2 = min(a[0], a[1]).toLong()

    for (i in 2 until len) {
        if (a[i] > max1) {
            max2 = max1
            max1 = a[i].toLong()
        }
        else if (a[i] > max2) {
            max2 = a[i].toLong()
        }
    }

    return max1 * max2
}
