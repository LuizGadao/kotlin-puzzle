package data_structure.search

fun main() {

    val values = Array(11) {
        (Math.random() * 1000).toInt()
    }

    //values.forEach { println(it) }

    println()
    bubbleSort(values.clone())
    println("insertion")
    insertionSort(values.clone()).forEach { print("${it} - ") }
    insertionSort2(values.clone())
    println("selection")
    selectionSort(values.clone()).forEach { print("${it} - ") }
    println("\nquick")

    val quick = values.clone()
    quickSort(quick, 0, quick.size-1)
    println("qtd quick interactions: $countQ")
    quick.forEach { print("${it} - ") }

    println("\nsum: ${mySum(values, values.size)}")
}

fun bubbleSort(array: Array<Int>): Array<Int> {

    var count = 0
    repeat(array.size) { i ->
        var j = i + 1
        while (j < array.size) {
            if (array[i] > array[j]) {
                val temp = array[j]
                array[j] = array[i]
                array[i] = temp
            }
            j++

            count++
        }
    }

    println("\nqtd bubble interactions: $count")

    return array
}

fun insertionSort(array: Array<Int>): Array<Int> {
    var count = 0
    var i = 1
    while (i < array.size) {
        val aux = array[i]
        var j = i -1
        while (j >= 0 && aux < array[j]) {
            array[j+1] = array[j]
            j--
            count++
        }
        array[j+1] = aux

        i++
    }

    println("\nqtd insertion interactions: $count")

    return array
}

fun insertionSort2(array: Array<Int>): Array<Int> {

    var count = 0
    var i = 1

    while(i < array.size) {

        var j = i - 1
        while (j >= 0 && array[j+1] < array[j]) {
            val aux = array[j+1]
            array[j+1] = array[j]
            array[j] = aux

            j--
            count++
        }

        i++
    }

    println("\nqtd insertion interactions 2: $count")

    return array

}

fun selectionSort(array: Array<Int>) : Array<Int> {
    var count = 0
    var i = 0
    while (i < array.size -1) {

        var j = i + 1
        var small = array[i]
        var smallIndex = i
        while (j < array.size) {
            if (array[j] < small) {
                small = array[j]
                smallIndex = j
            }
            j++
            count++
        }

        array[smallIndex] = array[i]
        array[i] = small

        i++
    }

    println("\nqtd selection qtd interactions: $count")

    return array
}

fun mySum(array: Array<Int>, n: Int) : Int {
    if (n ==0) return 0

    return array[n-1] + mySum(array, n-1)
}

var countQ = 0
fun quickSort(array: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(array, low, high)
        quickSort(array, low, pivotIndex)
        quickSort(array, pivotIndex + 1, high)
    }
}

fun partition(array: Array<Int>, low: Int, high: Int): Int {
    val indexPivot = (low + high) / 2
    val pivot = array[indexPivot]
    var i = low - 1
    var j = high + 1

    while (true) {

        do {
            i++
            countQ++
        } while (array[i] < pivot)

        do {
            j--
            countQ++
        } while (array[j] > pivot)

        if (i >= j) return j
        val aux = array[i]
        array[i] = array[j]
        array[j] = aux
        countQ++
    }
}
