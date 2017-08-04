package com.xue.string.template

/**
 * $ 符号在字符串中的效果
 *
 * 取值，嵌入运算式
 * 这个功能好神奇啊
 * */
fun main(args: Array<String>) {
    var a = 1

    val s1 = "a is $a"

    a = 2

    val s2 = "${s1.replace("is", "was")} , but now is $a , test 加入一个没有返回的调用 ${println("这是嵌入的函数式")}"

    println(s2)

}


