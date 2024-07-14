import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Tests {
    @Test
    fun testSample1() {
        val sequence = "001001"
        val blocks = countBlocksOfOnes(sequence)
        assertEquals(2, blocks, "countBlocksOfOnes($sequence)")
    }

    @Test
    fun testSample2() {
        val sequence = "11100101"
        val blocks = countBlocksOfOnes(sequence)
        assertEquals(3, blocks, "countBlocksOfOnes($sequence)")
    }

    @Test
    fun testSample3() {
        val sequence = "11111"
        val blocks = countBlocksOfOnes(sequence)
        assertEquals(1, blocks, "countBlocksOfOnes($sequence)")
    }

    @Test
    fun testSample4() {
        val sequence = "00000"
        val blocks = countBlocksOfOnes(sequence)
        assertEquals(0, blocks, "countBlocksOfOnes($sequence)")
    }
}
