package hacker_rank

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    var duration = measureTimeMillis {
        val candles = birthdayCakeCandles2(getValues())
        println(candles)
    }

    println("duration for solution 2: $duration")

    duration = measureTimeMillis {
        val candles = birthdayCakeCandles(getValues())
        println(candles)
    }
    println("duration for solution 1: $duration")
}

fun birthdayCakeCandles(candles: Array<Int>): Int {
    var n = 0
    var i = 0
    while (i < candles.size-1) {
        var equal = 1
        var y = i + 1
        while(y < candles.size) {
            //println("${candles[i]} - ${candles[y]}")
            if (candles[i] == candles[y]) equal++
            y++
        }
        if (equal > n) n = equal

        i++
    }

    return n
}
fun birthdayCakeCandles2(candles: Array<Int>): Int {
    var max = 0
    var repeat = 0
    var i = 0
    while (i < candles.size) {
        val value = candles[i]
        if (value > max) {
            max = value
            repeat = 1
        } else if (value == max) {
            repeat++
        }

        i++
    }

    return repeat
}

fun getValues() :Array<Int> {
    return File("src/leetcode.binary_search.algoExpert.main/resources/file_1.txt")
        .readLines()
        .flatMap { it.split(" ") }
        .map { it.toInt() }
        .toTypedArray()
}