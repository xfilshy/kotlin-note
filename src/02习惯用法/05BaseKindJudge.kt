package com.xue.base.kind.judge

/**
 * when语法和is的简单使用，没什么好说的
 * */
fun main(args: Array<String>) {
    judge(1)
    judge("1")
    judge(1.2f)
}

fun judge(value: Any?) {
    when (value) {
        is String -> println("value is String")
        is Int -> println("value in Int")
        else -> println("value unknown")
    }
}