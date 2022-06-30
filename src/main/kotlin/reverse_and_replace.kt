import java.lang.Exception

/**
 * Implement a function that
1. Reverse each word in the input string
2. replace the second symbol in each reversed word with a sharp character

 * Examples
 * "1234 5678" -> "4#21 8#65"
 * "1 5678" -> "1 8#65"
 * "This is a test" -> "s#hT s# a t#et"
 */


fun main() {
    val strTest = "1234 5678\n1 5678\nThis is a test \nLuiz Carlos"

    strTest
        .split("\n")
        .forEach { println(reverseAndReplaceLine(it)) }
}

fun String.replaceToSharp(position:Int = 1): String {
    val myChars = this.toCharArray()

    if (position < myChars.size) {
        myChars[position] = '#'
    }

    return String(myChars)
}

fun reverseAndReplaceLine(value: String) = value
        .split(" ")
        .map { it.reversed().replaceToSharp()}
        .joinToString(" ")


