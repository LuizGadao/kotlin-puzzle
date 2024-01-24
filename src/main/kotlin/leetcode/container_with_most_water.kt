package leetcode

import kotlin.math.min

/*
https://leetcode.com/problems/container-with-most-water/
 */
fun main() {
    var heights = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7) // 49
    println(getAreaBestSolution(heights) == 49)

    heights = intArrayOf(1, 1) // 1
    println(getAreaBestSolution(heights) == 1)

}

fun getAreaBestSolution(heights: IntArray) : Int {
    var l = 0
    var r = heights.size-1
    var maxArea = 0

    while (l < r) {
        val distance = r - l
        val area = distance * min(heights[l], heights[r])

        if (area > maxArea) maxArea = area

        if (heights[l] < heights[r])
            l++
        else
            r--
    }

    return maxArea
}

fun getArea(heights: IntArray) : Int {
    var i = 0
    var y = 1
    var maxArea = 0

    while (i < heights.size-1) {
        do {
            val a = heights[i]
            val b = heights[y]
            val min = min(a, b)
            val distance = (y + 1) - (i + 1)
            val area =  min * distance

            if (area > maxArea) maxArea = area

            y++
        } while (y < heights.size)
        i++
        y = i + 1
    }


    return maxArea
}
