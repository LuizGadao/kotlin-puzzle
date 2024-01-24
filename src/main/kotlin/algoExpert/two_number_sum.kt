package algoExpert

/**

 * Examples
 * "[3, 5, -4, 8, 11, 1, -1, 6]" targetSum  = 10 => [-1, 11]
 *
 */


fun main() {
    val numbers = mutableListOf(3, 5, -4, 8, 11, 1, -1, 6)
    println()
    println("result é: ${twoNumberSum(numbers, 10)}")
    println("result é: ${twoNumberSum2(numbers, 10)}")

    println("I love animals!\n" +
            "Let's check on the animals...\n" +
            "The deer looks fine.\n" +
            "The bat looks happy.\n" +
            "The lion looks healthy.")
}

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val result = arrayListOf<Int>()
    val len = array.size

    repeat(len) { i ->

        var y = i + 1
        while(y < len) {
            val n1 = array[i]
            val n2 = array[y]
            val sum = n1 + n2
            if (sum == targetSum) {
                result.add(n1)
                result.add(n2)
            }

            println(" $n1 + $n2 = $sum")
            y++
        }
    }


    return result
}

fun twoNumberSum2(array: MutableList<Int>, targetSum: Int): List<Int> {
    val myHash = hashMapOf<Int, Boolean>()

    for(x in array) {
        val y = targetSum - x
        if (myHash.containsKey(y)){
            return listOf(y, x)
        } else {
            myHash[x] = true
        }
    }


    return listOf()
}

fun maxSum(array:Array<Int>) {
    val myArray = LongArray(array.size) { array[it].toLong() }
    val greater = myArray.takeLast(4).sum()
    val smaller = myArray.take(4).sum()
    array.forEach{ println("i: $it") }
    println("myCount: $smaller $greater")
}

