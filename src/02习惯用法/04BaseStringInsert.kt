package com.xue.base.string.insert

/**
 * String内插 很简单 没什么好说的了
 *
 * 两种形式： $value 插入变量的值  ${} 插入运算式 运算式的结果就是返回值被插入String
 * */
fun main(args: Array<String>) {
    var value = 20
    println("String inset value $value")
    println("String inser block ${1 + 2}")
    println("String inser block ${println("随便搞啊")}")
}