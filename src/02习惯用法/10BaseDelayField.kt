package com.xue.base.delay.field

/**
 * 又一个新概念 lazy
 *
 * 我理解就是延迟初始化属性，lazy的形式申明后，属性的初始化时间会被当道属性第一次被调用时，因此他一定是一个 val 不可变的
 * 注意lazy的写法，有大用
 * */
val p: String by lazy {
    "xue"
}

fun main(args: Array<String>) {
    val p: String by lazy {
        "xue"
    }

    val list : List<Int> by lazy {
        listOf(1 , 2 ,3)
    }
}