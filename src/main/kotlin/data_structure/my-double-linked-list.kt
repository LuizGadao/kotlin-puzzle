package data_structure

class MyDoubleLinkedList<T> {

    internal data class Node<T>(
        val value: T,
        var next: Node<T>? = null,
        var prev: Node<T>? = null
    ) {

        override fun toString(): String {
            return buildString {
                if (prev != null) append("${prev?.value} <-")
                append("[$value]")
                if (next != null) append("->${next?.value}")
            }
        }

    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0
        get() = field

    fun push(value: T) {
        val newNode = Node(value)
        if (tail == null) tail = newNode
        else head?.prev = newNode

        newNode.next = head
        head = newNode
        size++
    }

    fun append(value: T) {
        val newNode = Node(value)
        if (head == null) head = newNode
        else tail?.next = newNode

        newNode.prev = tail
        tail = newNode
        size++
    }

    fun pop() {
        // has item
        if (tail?.prev != null) {
            tail?.prev?.next = null
            tail = tail?.prev
        } else {
            tail = null
            head = null
        }

        if (size > 0) size--
    }

    fun removeFirst() {
        if (head != null) {
            head?.next?.prev = null
            head = head?.next
        }

        if (head == null) tail = null

        if (size > 0) size--
    }

    fun removeAt(pos: Int) {

        if (pos > size) throw IndexOutOfBoundsException("pos = $pos, size = $size")

        // remove first and last node
        if (size == 1 || pos == size - 1) {
            pop()
            return
        }

        var i = 0
        var node = head
        while (node != null) {
            if (i == pos) {
                node.prev?.next = node.next
                node.next?.prev = node.prev
                node.next = null
                node.prev = null
            }

            node = node.next
            i++
        }
        size--
    }

    fun remove(value: T) {
        var node = head
        while (node != null)  {
            if (node.value == value) {
                if (node == head || node == tail) {
                    pop()
                    return
                }
                else {
                    node.prev?.next = node.next
                    node.next?.prev = node.prev
                    node.next = null
                    node.prev = null
                    size--
                    return
                }
            }

            node = node.next
        }
    }

    override fun toString(): String {
        return buildString {
            if (head == null) return "[]"

            var node = head
            append('[')
            while (node != null) {
                append("${node.value}")
                node = node.next
                if (node != null) append(", ")
            }
            append(']')
        }
    }
}

fun main() {
    val myLinkedList = MyDoubleLinkedList<Int>()
    myLinkedList.push(1)
    myLinkedList.push(2)
    myLinkedList.push(3)
    myLinkedList.removeAt(1)
    myLinkedList.removeAt(1)
    myLinkedList.removeAt(0)
    myLinkedList.append(1)
    myLinkedList.append(2)
    myLinkedList.append(1)
    myLinkedList.remove(2)
    myLinkedList.remove(1)
    myLinkedList.push(4)
    myLinkedList.append(5)
    myLinkedList.append(6)
    myLinkedList.append(7)
    println(myLinkedList)
    myLinkedList.pop()
    println(myLinkedList)
    myLinkedList.pop()
    println(myLinkedList)
    myLinkedList.pop()
    println(myLinkedList)
    myLinkedList.pop()
    println(myLinkedList)
    myLinkedList.pop()
    println(myLinkedList)
    myLinkedList.pop()
    println(myLinkedList)
    myLinkedList.pop()
    println(myLinkedList)
    myLinkedList.append(1)
    myLinkedList.append(2)
    myLinkedList.append(3)
    println(myLinkedList)
    myLinkedList.removeFirst()
    println(myLinkedList)
    myLinkedList.removeFirst()
    println(myLinkedList)
    myLinkedList.removeFirst()
    println(myLinkedList)
    myLinkedList.removeFirst()
    println(myLinkedList)

    var myArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    myArray.all { it == 1 }
}