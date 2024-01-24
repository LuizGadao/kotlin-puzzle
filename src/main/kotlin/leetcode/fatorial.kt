package leetcode



fun fatorial(n: Int) : Int {
    var total = 1
    var i = 1
    while(i <= n) {
        total *= i
        //println("$i - $total")
        i++
    }

    return total

}
