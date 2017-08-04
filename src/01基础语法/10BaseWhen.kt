package com.xue.base.`when`

/**
 * when语句 取代java中的switch语句，写法简单很多了，else 替代 default，但是貌似写不出来switch语言中那种判断穿透的效果了呢
 * 但是判断条件更多变，实际上可以实现 if elseif 语法
 * */
fun main(args: Array<String>) {
    testWhen02(1)
    testWhen02("a")
    testWhen02(Object())
}

fun testWhen01(value: Any?) {

    when (value) {
        1 -> println(1)
        2 -> println(2)
        3 -> println(3)
        "a" -> println("a")
        "b" -> println("b")
        else -> println(value)
    }
}


fun testWhen02(value: Any?) =

        when (value) {
            1,2 -> println(1)
            (value == 2) -> println(2)
            3 -> println(3)
            "a" -> println("a")
            "b" -> println("b")
            else -> println(value)
        }