fun changeMoney(money: Int): Int {
    val T = MutableList(maxOf(money + 1, 5)) {Int.MAX_VALUE}

    T[0] = 0
    T[1] = 1
    T[2] = 2
    T[3] = 1
    T[4] = 1

    for (i in 5..money) {
        T[i] = minOf(T[i], 1 + T[i - 1], 1 + T[i - 3], 1 + T[i - 4])
    }

    return T[money]
}
