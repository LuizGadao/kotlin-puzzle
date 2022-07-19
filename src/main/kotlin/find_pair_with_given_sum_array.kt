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
    //findPair(listOf(5, 2, 6, 8, 1, 9), 12)
}

fun findPair(numbers: List<Int>, target: Int) {
    val sortedNumber = numbers.sorted()
    val myPairs = arrayListOf<Pair<Int, Int>>()

    var i = 0
    val len = sortedNumber.size
    while (i < len -1) {
        val currentN = sortedNumber[i]
        var j = i + 1

         while (j < len) {
            val nextN = sortedNumber[j]
            if (currentN + nextN > target) break

            if (currentN + nextN == target) {
                myPairs.add(currentN to nextN)
            }

            println("i:${numbers[i]} j:${numbers[j]}")

            j++
        }

        i++
    }

    println(myPairs)
}

/*
i:0 j:1
i:0 j:2
i:0 j:3
i:0 j:4
i:0 j:5
i:1 j:2
i:1 j:3
i:1 j:4
i:1 j:5
i:2 j:3
i:2 j:4
 */