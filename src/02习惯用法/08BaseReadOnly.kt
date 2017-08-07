package com.xue.base.readonly

/**
 * 只读list 和 map ，也就是没有写入方法，如add，其实就是 kotlin中的 List 和 Map 两个接口类是不带写入方法的
 * 他们的可写入形式是 MutableList ， MutableMap
 *
 * listOf函数 和 mapOf 函数构造的是只读对象而已 没啥神奇的
 * */
fun main(args: Array<String>) {
    var list = listOf(1, 2, 3)
    var map = mapOf("a" to 1, "b" to 2, "c" to 3)

    println(list)
    println(map)
}