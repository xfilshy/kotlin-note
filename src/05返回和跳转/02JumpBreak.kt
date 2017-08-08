package com.xue.jump.`break`

/**
 * break。终止最直接包围它的循环。
 *
 * 带标签的break,单层循环无意义，多层循环时很有意思，你可以选择break到哪一层循环语句
 * 标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。
 * */
fun main(args: Array<String>) {
    test02()
}

/**
 * for基础用法
 * */
fun test01() {
    for (i in 1..10) {
        if (i == 4) break

        println("i == $i")
    }
}

fun test02() {
    println("进入了")
    for (i in 1..10) {
        flag@ for (j in 1..10) {
            if (i == 4) break@flag

            println("i == $i j = $j")
        }
    }
    println("完了")
}