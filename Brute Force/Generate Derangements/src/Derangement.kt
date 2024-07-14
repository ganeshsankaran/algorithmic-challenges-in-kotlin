
data class Derangement(private val permutation: IntArray) {
    override fun toString(): String = permutation.contentToString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Derangement
        if (!permutation.contentEquals(other.permutation)) return false
        return true
    }

    override fun hashCode(): Int = permutation.contentHashCode()

    fun length(): Int = permutation.size

    operator fun contains(k: Int): Boolean = permutation.contains(k)

    fun append(k: Int): Derangement = Derangement(permutation.plus(k))
}