fun countBlocksOfOnes(seq: CharSequence): Int {
    var ct = if (seq.firstOrNull() == '1') 1 else 0

    ct += (1 until seq.length)
        .count { seq[it] == '1' && seq[it - 1] == '0' }

    return ct
}
