package com.xue.generics

fun main(args: Array<String>) {
    /**
     * 最完整的写法
     * */
    var box1: Box<Int> = Box<Int>(1)

    /**
     * 类型自动推断类型
     * */
    var box2 = Box(2)
}

/**
 * 最普通的泛型
 * */
class Box<T>(t: T) {
    var value = t
}

