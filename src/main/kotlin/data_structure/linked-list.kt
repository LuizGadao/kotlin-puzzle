package data_structure

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


data class Element<T>(
    val value: T,
    var next: Element<T>? = null
)

class Iterator<T>(
    private var element: Element<T>? = null
) {

    fun hasNext(): Boolean {
        return element?.next != null
    }

    fun getNext(): Element<T>? {
        element = element?.next
        return element
    }
}

class LinkedList<T> {

    var first: Element<T>? = null
    var last: Element<T>? = null

    private var count = 0

    val iterator: Iterator<T> by lazy {
        Iterator(first)
    }

    fun add(value: T) {
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
        var previous: Element<T>? = null

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

    fun get(position: Int) : Element<T>? {
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

@OptIn(ExperimentalTime::class)
fun main() {
    val myList = LinkedList<String>()
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

    val qtd = 90_000
    val myArray = Array<Int>(size = qtd) { 0 }
    val myListTest = LinkedList<Int>()

    var time = measureTime {
        (0 until qtd).forEach {
            myArray[it] = it
        }
    }

    var timeList = measureTime {
        (0 until qtd).forEach {
            myListTest.add(it)
        }
    }

    println("$time to add $qtd in Array")
    println("$timeList to add $qtd in LinkedList")

    time = measureTime {
        (0 until qtd).forEach {
            myArray[it]
        }
    }

//    timeList = measureTime {
//        (0 until qtd).forEach {
//            myListTest.get(it)
//        }
//    }
    timeList = measureTime {
        while (myListTest.iterator.hasNext()) {
            myListTest.iterator.getNext()
        }
    }

    println("$time to get $qtd in Array")
    println("$timeList to get $qtd in LinkedList")
}