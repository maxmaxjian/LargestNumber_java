import java.lang.StringBuilder

class Solution2 : Solution {
    override fun largestNumber(nums: IntArray): String {
        val stringBuilder = StringBuilder()
        nums.sortedWith(object: Comparator<Int>{
            override fun compare(i: Int, j: Int): Int {
                val si = i.toString()
                val sj = j.toString()
                return (sj+si).compareTo(si+sj)
            }
        }).forEach {
            stringBuilder.append(it)
        }

        return if (stringBuilder[0] == '0') "0" else stringBuilder.toString()
    }
}