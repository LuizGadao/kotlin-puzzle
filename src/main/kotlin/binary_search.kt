import kotlin.system.measureTimeMillis

fun main() {
    val goldNumber = 145_444
    val myList = IntArray(1_000_000) { it }

    val duration = measureTimeMillis {
        binarySearch(myList.asList(), goldNumber)
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
            return goldNumber
        }

        if (kick < goldNumber) {
            bigger = middle -1
        } else {
            smaller = middle + 1
        }
    }

    return null
}