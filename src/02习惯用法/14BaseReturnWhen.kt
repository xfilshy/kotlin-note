package com.xue.base.`retrun`.`when`

/**
 * 其实没什么好说的 主要就是一个返回的完整性，但是这里又涉及到了一个默认返回值得问题
 * */
fun main(args: Array<String>) {
    test("red")
}

fun test(color: String): Int {
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