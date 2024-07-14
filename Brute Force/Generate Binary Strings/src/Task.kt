
// Implement additional functions and classes here if required
fun generateBinaryStrings(length: Int): List<String> {
    return when (length) {
        0 -> listOf("")
        else -> {
            val rec = generateBinaryStrings(length - 1)
            return rec.map { "0$it" } + rec.map { "1$it" }
        }
    }
}
