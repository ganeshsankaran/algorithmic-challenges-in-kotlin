fun change(money: Int): Int {
    var moneyRemaining = money
    var coins = 0

    while (moneyRemaining >= 10) {
        moneyRemaining -= 10
        coins++
    }

    while (moneyRemaining >= 5) {
        moneyRemaining -= 5
        coins++
    }

    while (moneyRemaining > 0) {
        moneyRemaining--
        coins++
    }

    return coins
}
