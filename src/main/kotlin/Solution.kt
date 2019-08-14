interface Solution {
    fun largestNumber(nums: IntArray): String
}

fun main() {
    val list = mutableListOf<Int>(1,1,2,3,5)
    val m = list.min()
    println("m = $m")
    list.remove(m!!)
    println("list = $list")
}