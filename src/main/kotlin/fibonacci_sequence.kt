
fun fibonacci(n: Int): Int {
    if (n < 1) throw IllegalArgumentException("error")

    if (n == 1) return 1

    var x = 1
    var y = 1
    var total = 0
    var i = 1
    while (i < n) {
        total = x + y
        x = y
        y = total
        i++
    }

    return total
}

fun fibonacciSequence(n: Int): List<Int> {

    //fib(1) = [1]
    //fib(2) = [1, 1]
    //fib(3) = [1, 1, 2]
    //fib(4) = [1, 1, 2, 3]
    //fib(5) = [1, 1, 2, 3, 5]
    //fib(6) = [1, 1, 2, 3, 5, 8]

    val result = mutableListOf<Int>()
    result.add(1)
    (1 until n).forEach { index ->
        result.add(fibonacci(index))
    }
    return result

}

fun fibSequence(n: Int): List<Int> {
    //fib(1) = [1]
    //fib(2) = [1, 1]
    //fib(3) = [1, 1, 2]
    //fib(4) = [1, 1, 2, 3]
    //fib(5) = [1, 1, 2, 3, 5]
    //fib(6) = [1, 1, 2, 3, 5, 8]

    if (n <= 0) return listOf()

    var prev = 1
    var next = 1
    var result = prev

    val sequence = mutableListOf<Int>()
    sequence.add(prev)

    repeat(n-1) {
        sequence.add(result)
        prev = next
        next = result
        result = next + prev
    }

    return sequence
}

fun main() {
    val value = 8
    println(fibonacciSequence(value))
    println(fibonacci(value))

    println(fibSequence(1))
    println(fibSequence(2))
    println(fibSequence(3))
    println(fibSequence(8))
}