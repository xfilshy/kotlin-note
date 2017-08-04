package com.xue.define.variable

/**
 * val 用来声明常量 声明赋值后变不可以改变
 *
 * a 的声明形式为最标准的结构
 * b 的声明方式省略了类型，有所赋值自行推导类型
 * c 的赋值为显示的赋值
 *
 * var 用来声明可变变量 , 可以改变，写法和val的声明基本一致
 * */
fun test() {
    val a: Int = 2
    val b = 10
    val c: Int
    c = 20

    var d = 10
    d += 2
}