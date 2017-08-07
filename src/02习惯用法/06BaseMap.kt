package com.xue.base.map

/**
 * 遍历过程理解应该很简单，但是这里有几个问题
 * 第一个 to关键字 声明一个Pair ，点进to的源码，是一个infix fun的函数，拷出来声明一个xx，一样有效，好神奇，这个写法后面一定要研究明白
 * 第二个 Map的泛型，值是 Map<String , String> 如果方法的泛型放的是 Map<Any , Any>,是会报错的 必须要申明成 Map<* , *>,这个好好研究下
 * */
fun main(args: Array<String>) {
    var map = mapOf("k1" to "v1", "k2" to "v2")
    var map2: Map<Any, Any> = mapOf("k1" xx "v1", "k2" xx "v2")
    test(map)
}

fun test(map: Map<*, *>) {
    for ((k, v) in map)
        println("element key = $k value = $v")
}

public infix fun <A, B> A.xx(that: B): Pair<A, B> = Pair(this, that)