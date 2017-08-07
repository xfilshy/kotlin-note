package com.xue.base.`try`

/**
 * try ... catch 的用法和java差不多，又出现了 默认返回 真的是厉害了我的哥 , 猜测 一个函数块的返回 如果无明确返回的话 将以最后一句执行的代码的值为准
 * */
fun main(args: Array<String>) {
    test()
}

fun test() {
    var result = try {
        1 / 0
        testWhen("red")
    } catch (e: ArithmeticException) {
        22
    }

    println("result == $result")
}

fun testWhen(color: String): Int {
    return when (color) {
        "red" -> {
            println("red is 1")
            1
        }
        "blue" -> 2
        "green" -> 3
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

