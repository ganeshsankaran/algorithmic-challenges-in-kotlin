fun forward(n: Int): IntArray {
    val T = IntArray(n + 1)
    T[0] = 0

    for (i in 1..n) {
        var ops = T[i - 1] + 1 // number of ops to add 1
        intArrayOf(2, 3)
            .asSequence()
            .filter { i % it == 0 }
            .forEach { ops = minOf(ops, T[i / it] + 1) }
        T[i] = ops
    }

    return T
}

fun backward(n: Int, T: IntArray): List<Int> {
    val result = mutableListOf<Int>()

    var i = n
    while (i > 1) {
        result.add(i)
        i = when {
            T[i] == T[i - 1] + 1 -> i - 1 // add case
            (i % 2 == 0) && (T[i] == T[i / 2] + 1) -> i / 2 // mul 2 case
            else -> i / 3 // mul 3 case
        }
    }

    return result.apply {
        add(1)
        reverse()
    }
}

fun findMinimumOperations(n: Int): List<Int> {
    val T = forward(n)
    return backward(n, T)
}
