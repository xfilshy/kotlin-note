package com.xue.base.expand.funcation

/**
 * 这个是一个相当好用的功能，类扩展，给一个已经存在的类扩展方法，非常厉害的写法，可以替代很多的简单继承
 * 这个扩展方式，好像不适用于方法的重写,详细后续具体研究
 * */
fun main(args: Array<String>) {
    println("String testStringDouble == ")
    println("String testStringDouble == ".toString())
}

fun String.stringDouble(): String {
    return this.toString() + this.toString()
}

fun String.toString(): String {
    return "123"
}

