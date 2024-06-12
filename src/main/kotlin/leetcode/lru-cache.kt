package leetcode

import java.util.LinkedList


class LRUCache(private val capacity: Int) {

    private var stack = LinkedList<Int>()
    private var myCache = hashMapOf<Int, Int>()

    fun get(key: Int): Int {
        var result = -1
        val value = myCache.get(key)

        if (value != null) {
            val set = hashMapOf<Int, Int>()
            stack.forEachIndexed { index, i -> set.put(i, index) }
            val index = set.get(value)
            stack.remove(index)
            stack.add(key)
        }

        return value ?: -1
    }

    fun put(key: Int, value: Int) {
        if (myCache.containsKey(key)) {
            stack.remove(key)
        }
        myCache.put(key, value)
        stack.add(key)

        if (myCache.size > capacity) {
            val k = stack.removeFirst()
            myCache.remove(k)
        }

        if (stack.size > capacity) stack.removeFirst()

    }

}

fun main() {
    val lruCache = LRUCache(capacity = 2)
    lruCache.put(key = 1, value = 11)
    lruCache.put(key = 2, value = 22)
    lruCache.put(key = 3, value = 33)
    lruCache.get(key = 2)
    lruCache.put(key = 4, value = 44)
    lruCache.put(key = 2, value = 1)
    lruCache.put(key = 1, value = 1)
    lruCache.put(key = 2, value = 3)
    lruCache.put(key = 4, value = 1)
    lruCache.get(key = 1)
    println(lruCache.get(key = 2))


//    var strtestCase = "[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26"
//    var resultTestCase = "null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,24,null,4,29,30,null,-1,-1,null,null,null,null,-1,null,null,null,null,17,22,-1,null,null,null,-1,null,null,null,20,null,null,null,29,-1,-1,null,null,null,null,20,null,null,null,null,null,null,null"
//    val results = resultTestCase.split(",")
//
//    val testCase = strtestCase.split("],").map { it.replace("[", "") }
//    testCase.forEachIndexed { index, value ->
//        //println(value)
//        val split = value.split(",").map { it.toInt() }
//
//
//        val resultExpected = results.get(index = index)
//
//        if (split.size == 1) {
//            val resultCache = lruCache.get(split[0])
//            val answer = resultCache == resultExpected.toInt()
//            if (!answer)
//                println("the answer is: ${resultCache == resultExpected.toInt()} to case ${split[0]} expected: $resultExpected")
//        }
//        else
//            lruCache.put(key = split[0], split[1])
//    }
//
//    println(lruCache)

}