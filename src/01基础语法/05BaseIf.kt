package com.xue.base.`if`

/**
 * if条件语句的简单介绍
 *
 * maxOf01 和 maxOf02 和 maxOf03 实际上是一个方法,比较简单不在赘述
 *
 * if () 运算式 else 运算式 根据判断结果返回运算式的值
 *
 * main方法和maxOf04做了一个对于结果推导的测试，测试结果很意外，有一点动态语言的感觉了 变量 x 变成了一个类型不固定了
 *
 * 实际上 maxOf04 和 maxOf05 是一样的
 *
 * */
fun maxOf01(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf02(a: Int, b: Int): Int = if (a > b) a else b

fun maxOf03(a: Int, b: Int) = if (a > b) a else b

fun maxOf04(a: Int, b: Int) = if (a > b) "a" else b

fun maxOf05(a: Int, b: Int): Any = if (a > b) "a" else b

fun main(args: Array<String>) {

    println("maxOf04 方法测试 ：\n a = 2 , b = 1  结果：${maxOf04(2, 1)} \n a = 1 , b = 2  结果：${maxOf04(1, 2)} ")

    var x = maxOf04(1, 2)

    println("x == " + x + "  " + x::class)

    x = maxOf04(2, 1)

    println("x == " + x + "  " + x::class)

}

