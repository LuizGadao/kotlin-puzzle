package data_structure




class MyLinkedList<T> {

    internal data class Node<T>(
        val value: T,
        var next: Node<T>? = null
    ) {
        override fun toString(): String {
            return if (next != null)
                "$value -> $next"
            else "$value"
        }
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty() = size == 0

    fun push(value: T): MyLinkedList<T> = apply {
        head = Node(value = value, next = head)
        if (tail == null) tail = head
        size++
    }

    fun append(value: T): MyLinkedList<T> = apply {
        if (isEmpty()) {
            push(value)
            return@apply
        }

        val newNode = Node(value)
        tail?.next = newNode
        tail = newNode
        size++
    }

    fun pop(): T? {
        if (isEmpty()) return null

        val node = head
        head = node?.next
        decrementSize()
        return node?.value
    }

    fun removeLast(): T? {
        if (isEmpty()) return null

        val prevNode = nodeAt(size-2)
        prevNode?.next = null
        tail = prevNode
        decrementSize()

        return prevNode?.value
    }

    internal fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var i = 0
        while (currentNode != null && i < index) {
            currentNode = currentNode.next
            i++
        }

        return currentNode
    }

    fun insertAt(value: T, index: Int) {
        if (index == 0) {
            push(value = value)
        } else if (index >= size) {
            append(value)
        } else {

            var currentNode = head
            var preNode = currentNode

            var i = 0
            while (i < index && currentNode?.next != null) {
                preNode = currentNode
                currentNode = currentNode.next
                i++
            }

            preNode!!.next = Node(value, currentNode)
            size++
        }
    }

    private fun decrementSize() {
        size--
        if (size == 0) {
            head = null
            tail = null
        }
    }

    override fun toString(): String {
        return if (size == 0) {
            "the list is empty"
        } else {
            head.toString()
        }
    }
}

fun main() {

    val myList = MyLinkedList<Int>()
    myList.toString()

    myList.append(1)
    myList.append(3)
    myList.append(4)

    //myList.push(3).push(4).push(10)
    println(myList)

    //myList.append(30).append(50)
    //println(myList)

    myList.insertAt(2, 1)
    myList.insertAt(0, 0)
    myList.insertAt(5, 5)
    myList.insertAt(15, 15)
    println(myList)
    myList.pop()
    myList.pop()
    myList.removeLast()
    myList.removeLast()
    myList.removeLast()
    myList.removeLast()
    myList.removeLast()

    println(myList)

    println("get node at: ${myList.nodeAt(1)?.value}")
    println("get node at: ${myList.nodeAt(0)?.value}")
}