package leetcode

fun fibonacci(n: Int) : Int {

    if (n <= 0) return 0
    if (n == 1) return 1

    return fibonacci(n-1) + fibonacci(n-2)
}

fun fibonacciWithArray(n: Int) : Int {

    if (n == 0) return 0
    if (n == 1) return 1

    var a = 0
    var b = 1
    var total = 0

    var i = 2
    while (i <= n) {
        total = a + b
        a = b
        b = total
        i++
    }

    return total
}