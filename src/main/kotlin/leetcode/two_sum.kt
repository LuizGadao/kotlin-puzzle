package leetcode

//https://leetcode.com/problems/two-sum/description/
fun twoSum(nums: IntArray, target: Int): IntArray {
    repeat(nums.size) { i ->
        var y = i + 1
        while (y < nums.size) {
            val n1 = nums[i]
            val n2 = nums[y]

            if (n1 + n2 == target) return intArrayOf(i, y)
            y++
        }
    }

    throw Exception("invalid values")
}

fun twoSumFast(nums: IntArray, target: Int): IntArray {
    val myHash = hashMapOf<Int, Int>()

    repeat(nums.size){ index ->
        val value = nums[index]
        val diff = target - value

        if (myHash.containsKey(diff))
            return intArrayOf(myHash[diff]!!, index)
        else
            myHash[value] = index
    }

    throw Exception("invalid values")
}

fun test() {
    println("test - luiz")
}
fun main() {
    twoSum(intArrayOf(2, 7, 11, 15), 9).forEach { println(it) }
    twoSumFast(intArrayOf(2, 7, 11, 15), 9).forEach { println(it) }
}