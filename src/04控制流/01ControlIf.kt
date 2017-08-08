package com.xue.control.`if`

/**
 * max01 max02 max03 三个方法结果和作用完全一样
 * 01是普通青年 02是二逼青年 03文艺青年
 * */
fun main(args: Array<String>) {

}


fun max01(a: Int, b: Int): Int {
    var max = a
    if (b > a) max = b

    return max
}

fun max02(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun max03(a: Int, b: Int) = if (a > b) a else b

/**
 * if的分支可以是代码块，最后的表达式作为该块的值，这个细节还是可以关注一下的
 * */
fun max04(a: Int, b: Int): Int {
    return if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
}