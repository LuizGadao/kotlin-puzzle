package binary_search

import kotlin.system.measureTimeMillis

fun main() {
    val goldNumber = -1//144_567
    val myList = IntArray(10_000_000) { it }

    val duration = measureTimeMillis {
        val myGoldNumber = binarySearch(myList.asList(), goldNumber)
        println("my goldNumber is $myGoldNumber")
    }

    println("duration: $duration for search $goldNumber in ${myList.size}")

}

fun binarySearch(items: List<Int>, goldNumber:Int): Int? {
    var bigger = items.size -1
    var smaller = 0

    while (smaller <= bigger) {
        val middle = (smaller + bigger) / 2
        val kick = items[middle]

        if (kick == goldNumber) {
            return kick
        }

        if (goldNumber < kick) {
            bigger = middle -1
        } else {
            smaller = middle + 1
        }
    }

    return null
}