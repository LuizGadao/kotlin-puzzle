package data_structure.search

fun main() {

    var values = Array(10) {
        (Math.random() * 10_000).toInt()
    }

    values.forEach { println(it) }

    println("Which number do you search?")
    val valueToSearch = readLine()?.toInt()

    var hasValueInArray = false
    for (n in values) {
        if (valueToSearch == n) {
            hasValueInArray = true
            break
        }
    }

    if (hasValueInArray)
        println("find a value $valueToSearch in Array")
    else
        println("not find a value $valueToSearch in array")

}