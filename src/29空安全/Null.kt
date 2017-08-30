package com.xue.`null`

fun main(args: Array<String>) {
    test1()

    test2()

    test3()

}


/**
 * 空安全判断
 *
 * ?.       非空调用判定目标的成员
 * ?.let    非空调用函数块
 * ?:       左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。
 * */
fun test1() {
    var s: String? = "123"

    s?.let { println("s not null s == $s") }

    s = null

    s ?: println("s is null s == $s")
}

/**
 * 安全的类型转换
 *
 * as? 如果尝试转换不成功(包括类型异常)则返回 null
 * */
fun test2() {
    var a: Any? = 123

    var s = a as? String

    println("s == $s")
}

/**
 * 如果你有一个可空类型元素的集合，并且想要过滤非空元素，你可以使用 filterNotNull 来实现。
 * */
fun test3() {
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
}