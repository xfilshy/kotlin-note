package com.xue.control.`for`

/**
 * for 循环可以对任何提供迭代器（iterator）的对象进行遍历
 * */
fun main(args: Array<String>) {

}

/**
 * 迭代器型的对象 都能被for遍历
 * */
fun test01() {
    var t = TestList<Int>()

    for (x in t) println(x)
}

/**
 * 这个效果我喜欢
 * */
fun test02() {
    var array = arrayOf("1", "2", "3")

    for ((index, value) in array.withIndex()) {
        println("index : $index  value : $value")
    }

    for ((index, index2, value) in array.withIndex2()) {
        println("index : $index  index2 : $index2  value : $value")
    }
}

public fun <T> Array<out T>.withIndex2(): TestListIterator<IndexedValue2<T>> {
    return TestListIterator<IndexedValue2<T>>()
}


public data class IndexedValue2<out T>(public val index: Int, public val index2: Int, public val value: T)


class TestList<T> {

    operator fun iterator(): Iterator<T> {
        return TestListIterator()
    }
}

class TestListIterator<T> : Iterator<T> {

    operator override fun hasNext(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    operator override fun next(): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}