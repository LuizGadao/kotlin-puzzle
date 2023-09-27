
fun main() {
    val array = mutableListOf(5, 1, 22, 25, 6, 8, 10, -1)
    val subSequence = mutableListOf(5, 1, 22, 22, 25, 6, -1, 8, 10)
    val subSequence1 = mutableListOf(5, 1, 25, 22, 6, -1, 8, 10)
    val subSequence2 = mutableListOf(-4, 8, -10)
    val subSequence3 = mutableListOf(1, 25, -1)
    println(isValidSubsequence(array, subSequence))
    println()
    println(isValidSubsequence(array, subSequence1))
    println()
    println(isValidSubsequence(array, subSequence2))
    println()
    println(isValidSub(array, subSequence3))
}

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var nextIndexInArray = 0
    sequence.forEachIndexed { index, value ->
        val indexOf = array.indexOf(value)

        if (indexOf == -1 || indexOf < nextIndexInArray || indexOf < index) {
            return false
        }

        nextIndexInArray = indexOf
        println("value: $value, indexOf: $nextIndexInArray, index: $index")
    }

    return true
}

fun isValidSub(array: List<Int>, sequence: List<Int>): Boolean {
    var copyArray = array.toIntArray()
    var result = true

    sequence.forEach { i ->
        val indexOf = copyArray.indexOf(i)
        if (indexOf == -1) return false

        copyArray = copyArray.sliceArray(indexOf+1..(copyArray.size-1))
    }

    return result
}

