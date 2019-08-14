import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(
    private val input: IntArray,
    private val expected: String) {
    private val soln = Solution3()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun params() = arrayOf(
            arrayOf(intArrayOf(10,2), "210"),
            arrayOf(intArrayOf(9,5,3,34,30), "9534330"),
            arrayOf(intArrayOf(0,0,0,0,0,0,0,0,0), "0"),
            arrayOf(intArrayOf(121,12), "12121")
        )
    }

    @Test
    fun test() {
        assertEquals(expected, soln.largestNumber(input))
    }
}