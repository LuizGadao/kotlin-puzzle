package leetcode

import java.util.*

class MyDoubleLinkedList<T> {

    data class Node<T>(
        var prev: Node<T>? = null,
        var value: T,
        var next: Node<T>? = null
    )

    private var size = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun addFirst(value: T) {
        val h = head
        val newNode = Node(null, value, h)
        head = newNode
        if (h == null) {
            tail = newNode
        } else {
            h.prev = newNode
        }
        size++
    }

    override fun toString(): String {
        var curr = head
        if (curr == null) return "[]"
        else {
            val strBuilder = StringBuilder("[")
            while (curr != null) {
                strBuilder.append(curr.value)
                curr = curr.next
                if (curr?.value != null) strBuilder.append(", ")
            }
            return strBuilder.append(']').toString()
        }
    }

}
class LRUCacheV2(private val capacity: Int) {

    val queue = LinkedList<Pair<Int, Int>>()
    val cache = mutableMapOf<Int, Pair<Int, Int>>()

    fun get(key: Int): Int {
        var result = -1
        val keyInCache = key in cache
        if (keyInCache) {
            val node = cache[key]
            queue.remove(node)
            queue.add(node!!)
            result = node.second
        }

        return result
    }

    fun put(key: Int, value: Int) {
        val node = key to value

        if (key in cache) {
            queue.remove(cache[key])
        }

        queue.add(node)
        cache[key] = node
        if (queue.size > capacity) {
            val firstNode = queue.removeFirst()
            cache.remove(firstNode.first)
            cache -= firstNode.first
        }
    }
}

fun main() {
    val lruCache = LRUCacheV2(capacity = 2)
    /*lruCache.put(key = 1, value = 11)
    lruCache.put(key = 2, value = 22)
    lruCache.put(key = 3, value = 33)
    lruCache.get(key = 2)
    lruCache.put(key = 4, value = 44)
    lruCache.put(key = 2, value = 1)
    lruCache.put(key = 4, value = 1)
    lruCache.put(key = 1, value = 1)
    lruCache.put(key = 2, value = 3)
    lruCache.get(key = 1)
    lruCache.put(key = 4, value = 1)*/

    val myDoubleList = MyDoubleLinkedList<Int>()
    myDoubleList.addFirst(3)
    myDoubleList.addFirst(2)
    myDoubleList.addFirst(1)

    println(myDoubleList)
}