package leetcode

fun main() {
    println(lengthOfLongestSubstring("pwwkew") == 3)
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("abcabcbb") == 3)
    println(lengthOfLongestSubstring("dvdf") == 3)
    println(lengthOfLongestSubstring("au") == 2)
    println(lengthOfLongestSubstring("") == 0)
    println(lengthOfLongestSubstring(" ") == 1)
    println(lengthOfLongestSubstring("bbbbb") == 1)
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0

    var startIndex = 0
    var longestStr = ""
    var oldLongestStr = ""

    var nextChar = ""

    while (startIndex < s.length) {
        nextChar = s.substring(startIndex, startIndex + 1)

        if (oldLongestStr.contains(nextChar).not()) {
            oldLongestStr += nextChar
        } else {
            oldLongestStr = oldLongestStr.removeRange(0, oldLongestStr.indexOf(nextChar)+1)
            oldLongestStr += nextChar
        }

        if (oldLongestStr.length > longestStr.length) {
            longestStr = oldLongestStr
        }

        startIndex++
    }

    return longestStr.length
}