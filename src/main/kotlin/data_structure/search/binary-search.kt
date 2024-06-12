package data_structure.search

fun main() {

    val values = Array(1_000_000) {
        it * 2
    }

    //values.forEach { print("$it,") }

    val search = binarySearch(3, values)
    println("Do you search a value: ${search.first}")
    println("How many steps: ${search.second}")
}

fun binarySearch(value:Int, array: Array<Int>) : Pair<Boolean, Int> {
    var begin = 0
    var end = array.size-1
    var hasFound = false
    var count = 0
    while (begin <= end) {
        count++
        val middle = (begin + end) / 2
        if (value == array[middle]) {
            hasFound = true
            break
        } else if (value < array[middle]) {
            end = middle - 1
        } else {
            begin = middle + 1
        }
    }

    return hasFound to count
}

