
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

fun main() {
    val value = 8
    println(fibonacciSequence(value))
    println(fibonacci(value))
}