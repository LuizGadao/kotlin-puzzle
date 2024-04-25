package data_structure.search

fun main() {

    val values = Array(10) {
        (Math.random() * 1000).toInt()
    }

    values.forEach { println(it) }

    println()
    bubbleSort(values).forEach {
        println(it)
    }
}

fun bubbleSort(array: Array<Int>): Array<Int> {

    repeat(array.size) { i ->
        var j = i + 1
        while (j < array.size) {
            if (array[i] > array[j]) {
                val temp = array[j]
                array[j] = array[i]
                array[i] = temp
            }
            j++
        }
    }

    return array
}