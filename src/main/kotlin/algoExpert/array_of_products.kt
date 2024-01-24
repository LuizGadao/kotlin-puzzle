package algoExpert

import kotlin.system.measureTimeMillis


fun arrayOfProducts(array: List<Long>): List<Long> {
    val result = mutableListOf<Long>()

    var len = array.size
    var i:Long = 0;
    while (i < len) {
        val copy = array.toMutableList()
        copy.removeAt(i.toInt())
        val reduce:Long = copy.reduce { acc, i -> acc * i }

        result.add(reduce)
        i++
    }

    return result
}

fun arrayOfProducts2(array: List<Long>): List<Long> {
    val result = mutableListOf<Long>()

    var len = array.size
    var i = 0;
    while (i < len) {
        var product: Long = 1

        var j = 0
        while (j < len) {
            if (i != j)
                product *= array[j]

            j++
        }
        result.add(product)

        i++
    }

    return result
}

fun arrayOfProducts3(array: List<Long>): List<Long> {
    val result = mutableListOf<Long>()

    val leftProducts = Array(array.size) { 1L }
    val rightProducts = Array(array.size) { 1L }

    var i = 0
    var product = 1L
    while (i < array.size) {
        leftProducts[i] = product
        product *= array[i]
        i++
    }

    i--
    product = 1L
    do {
        rightProducts[i] = product
        product *= array[i]
        i--
    } while (i >= 0)

    repeat(array.size) {
        result.add(rightProducts[it] * leftProducts[it])
    }

    result.forEach{ println(it) }

    return result
}

fun arrayOfProducts4(array: List<Long>): List<Long> {
    val leftProducts = Array(array.size) { 1L }
    val result = Array(array.size) { 0L }

    var product = 1L
    repeat(array.size) { i ->
        leftProducts[i] = product
        product *= array[i]
    }

    product = 1L
    for (i in array.size-1 downTo 0) {
        result[i] = leftProducts[i] * product
        product *= array[i]
    }

    result.forEach { println(it) }

    var str = ""

    return result.toList()
}

fun twoSum(numbers: IntArray, target: Int): Pair<Int,Int> {
    var i = 0
    while (i < numbers.size) {
        var j = i + 1

        while (j < numbers.size) {
            val n1 = numbers[i]
            val n2 = numbers[j]

            if (n1 + n2 == target) return i to j
            j++
        }

        i++
    }

    return 0 to 0
}

fun main() {
    val myList = listOf(5L, 1L, 4L, 2L)//Array(50){ (it+1).toLong() }

    //arrayOfProducts(toList)
    //arrayOfProducts2(toList)
    //arrayOfProducts3(myList)
    //arrayOfProducts4(myList)

    println(twoSum(intArrayOf(1,2,3), 4))
}