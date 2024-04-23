package data_structure


data class Element(
    val value: String,
    var next: Element? = null
)

class LinkedList {

    var first: Element? = null
    var last: Element? = null

    private var count = 0

    fun add(value: String) {
        val new = Element(value = value)
        if (count == 0) {
            first = new
            last = first
        }
        else {
            last?.next = new
            last = new
        }

        count++

    }

    fun remove(value: String) {
        var actual = first
        var previous: Element? = null

        (0 until count).forEach {
            if (actual?.value == value) {
                if (count == 1) {
                    first = null
                    last = null
                }
                else if (actual == first) {
                    first = actual?.next
                    actual = null
                }
                else if (actual == last) {
                    last = previous
                    previous?.next = null
                }
                else {
                    previous?.next = actual?.next
                    actual = null
                }

                count--
                return
            }
            previous = actual
            actual = actual?.next
        }
    }

    fun get(position: Int) : Element? {
        var actual = first
        (0 until position).forEach { i ->
            if (i == position) {
                return actual
            }

            actual?.next?.let {
                actual = it
            }
        }

        return actual
    }

    fun getCount() = count

}

fun main() {
    val myList = LinkedList()
    myList.add("AC")
    myList.add("SP")
    myList.add("CE")
    myList.add("RJ")

    println("show values")
    (0 until myList.getCount()).forEach {
        println("value: ${myList.get(it)?.value}")
    }

    var position = 2

    println("\nremove AC\n")
    myList.remove("AC")

    println("show values")
    (0 until myList.getCount()).forEach {
        println("value: ${myList.get(it)?.value}")
    }

    println("\nremove RJ\n")
    myList.remove("RJ")

    println("show values")
    (0 until myList.getCount()).forEach {
        println("value: ${myList.get(it)?.value}")
    }

    println("\nremove all\n")
    myList.remove("CE")
    myList.remove("SP")

    println("show values")
    (0 until myList.getCount()).forEach {
        println("value: ${myList.get(it)?.value}")
    }
}