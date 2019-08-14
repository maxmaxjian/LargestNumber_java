class Solution1 : Solution {

    override fun largestNumber(nums: IntArray): String {
        val map = mutableMapOf<Char,MutableList<Int>>().also {
            nums.forEach { num->
                it.getOrPut(num.toString()[0], { mutableListOf() }).add(num)
            }
        }

        val stringBuilder = StringBuilder()
        var list = map.maxBy { it.key }
        while (list != null) {
            var n = largest(list.value)
            while (n != null) {
                stringBuilder.append(n)
                list.value.remove(n)
                n = largest(list.value)
            }
            map.remove(list.key)
            list = map.maxBy { it.key }
        }
        return if (stringBuilder[0] == '0') "0" else stringBuilder.toString()
    }

    fun largest(nums: MutableList<Int>): Int? {
        if (nums.isEmpty()) {
            return null
        } else {
            var arr = mutableListOf<Int>().also { it.addAll(nums) }
            var idx = 0
            var m = arr.maxBy { num ->
                val s = num.toString()
                if (s.length > idx) {
                    s[idx]
                } else {
                    s[0]
                }
            }
            var after = arr.filter { it.toString()[idx] == m.toString()[idx] }.toMutableList()
            while (after.size > 1) {
                arr = after
                idx++
                m = arr.maxBy { num ->
                    val s = num.toString()
                    if (s.length > idx) {
                        s[idx]
                    } else {
                        s[0]
                    }
                }
//                after = arr.filter { when {
//                    it.toString().length > idx -> it.toString()[idx] == m.toString()[idx]
//                    else -> it.toString()[0] == m.toString()[idx]
//                } }.toMutableList()
                if (m.toString().length > idx) {
                    after = arr.filter {
                        when {
                            it.toString().length > idx -> it.toString()[idx] == m.toString()[idx]
                            else -> it.toString()[0] == m.toString()[idx]
                        }
                    }.toMutableList()
                } else {
                    return m
                }
            }
            if (after.size == 1) {
                return after[0]
            } else {
                return arr[0]
            }
        }
    }
}