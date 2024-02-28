package leetcode

/*
https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
 */
fun isPalidromic(s: String) = s == s.reversed()

fun isPalindrome(s: String): Boolean {

    var left = 0
    var right = s.length -1

    while (left != right && left < right) {
        if (s[left] != s[right])
            return false

        left++
        right--
    }

    return true
}

fun main() {
    var strs = listOf("cqllrtyhw","swwisru","gpzmbders","wqibjuqvs","pp","usewxryy","ybqfuh","hqwwqftgyu","jggmatpk")

    val result = strs.firstOrNull { isPalindrome(it) }

    println("racecar is palindromic: $result")
    println("racecar is palindromic: ${isPalindrome("racecarrrrrrr")}")
    println("result: $result")
}