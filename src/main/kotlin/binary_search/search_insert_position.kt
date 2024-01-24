package binary_search

fun main() {
    var nums = arrayOf(1, 3, 5, 6)
    println(getIndexInsert(nums, 5) == 2)

    nums = arrayOf(1, 3, 5)
    println(getIndexInsert(nums, 3) == 1)

    nums = arrayOf(4, 7, 9, 15)
    println(getIndexInsert(nums, 2) == 0)

    nums = arrayOf(1, 3, 5, 6)
    println(getIndexInsert(nums, 2) == 1)

    nums = arrayOf(1, 3, 5, 6)
    println(getIndexInsert(nums, 7) == 4)

    nums = arrayOf(5, 7, 9, 15)
    println(getIndexInsert(nums, 5) == 0)
}

fun getIndexInsert(nums: Array<Int>, target: Int) : Int {
    var bigger = nums.size -1
    var smaller = 0
    var middle: Int
    var kick: Int

    while (smaller <= bigger) {
        middle = (smaller + bigger) / 2
        kick = nums[middle]

        if (kick == target) return middle

        if (kick < target)
            smaller = middle + 1
        else
            bigger = middle - 1
    }

    return smaller
}