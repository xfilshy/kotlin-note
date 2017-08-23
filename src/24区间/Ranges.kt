package com.xue.ranges

fun main(args: Array<String>) {

}

/**
 * 区间的一个简单写法
 * 1 .. 10 代表  [1 , 10] 的闭合 整数区间（IntRange） 也就是（1，2，3，4，5，6，7，8，9，10）
 *
 * r1 和 r2 是一样的
 * */
fun test1(value: Int) {
    var r1 = IntRange(1, 10)
    var r2 = 1..10

    if (value in 1..10) println("value:$value in 1 .. 10")
}

/**
 * 因为实现了迭代器 所以 循环语句也可
 * */
fun test2() {
    for (x in 1..10) {
        println("x = $x")
    }
}