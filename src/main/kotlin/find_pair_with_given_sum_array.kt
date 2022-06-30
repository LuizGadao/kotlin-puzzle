/*
Input:

nums = [8, 7, 2, 5, 3, 1]
target = 10

Output:

Pair found (8, 2)
or
Pair found (7, 3)


Input:

nums = [5, 2, 6, 8, 1, 9]
target = 12

Output: Pair not found
 */

fun main() {
    findPair(listOf(8, 7, 2, 5, 3, 1), 10)
    findPair(listOf(5, 2, 6, 8, 1, 9), 12)
}

fun findPair(numbers: List<Int>, target: Int) {
    val sortedNumber = numbers.sorted()
    val myPairs = arrayListOf<Pair<Int, Int>>()

    var i = 0
    val len = sortedNumber.size
    while (i < len -1) {
        val currentN = sortedNumber[i]
        var j = i + 1

        loop@ while (j < len) {
            val nextN = sortedNumber[j]
            if (currentN + nextN > target) break@loop

            if (currentN + nextN == target) {
                myPairs.add(currentN to nextN)
            }

            j++
        }

        i++
    }

    println(myPairs)
}