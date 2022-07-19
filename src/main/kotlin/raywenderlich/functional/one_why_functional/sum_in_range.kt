package raywenderlich.functional

import java.time.Instant

fun main() {
    val values = listOf("1", "2", "3", "4", "5", "6", "7")
    val range = 1..3
    println(sumInRange(values, range))

    3.times {
        println("Luiz")
    }

    4.timesWithIndex { n ->
        println("value: $n")
    }

    /*
    val timeSpeed = chrono { 100_000.times{
        println("Luiza")
    } }
    println("timeSpeed: $timeSpeed")
    */

    val oneSec = { Thread.sleep(1000) }
    println(chrono(oneSec))

    println(updateDirty(11, filter))
}

fun Int.times(fn: ()-> Unit) =
    (1..this).forEach { fn() }

fun Int.timesWithIndex(fn:(Int)-> Unit) =
    (1..this).forEach(fn)

fun isValidNumber(str: String): Boolean {
    return try {
        str.toInt()
        true
    } catch(e: Exception) {
        false
    }
}

fun chrono(fn: ()-> Unit): Long {
    val start = System.currentTimeMillis()
    fn()
    return System.currentTimeMillis() - start
}

fun sumInRange(input: List<String>, range: IntRange) = input
    .filter(::isValidNumber)
    .map{ it.toInt() }
    .filter{ it in range }
    .sum()

val filter: (Int) -> Int = { value -> value / 2 }

fun updateDirty(dirty: Int, operation:(Int) -> Int): Int {
    return operation(dirty)
}
