package com.xue.base.`while`

/**
 * white循环语句好像没什么好说的 什么语言都一样 那暂且就不聊他了
 * */
fun main(args: Array<String>) {

    var list = listOf(1, 2, 3)
    var index = 0
    while (index < list.size) {
        println("list index ${index} value == ${list[index]}")
        index++
    }
}

