fun main() {
    val myList = mutableListOf(1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9)

    var qtdZero = 0;
    var i = 0;
    while (i < myList.size) {
        if (myList[i] == 0) {
            myList.removeAt(i)
            qtdZero++
        }
        i++
    }

    repeat(qtdZero) { myList.add(0) }

    println(myList)

}