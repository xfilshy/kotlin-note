package com.xue.base.list.filter

/**
 * 集合筛选 其实filter这个函数没什么好说的，实际上就让方法体为true的结果被留下
 *
 * 这里有意思的是 两条打印的写法 （个人理解）
 * 第一条：写法其实是一个lambda表达式申明的匿名函数
 * 第二条：是一个条件判断
 * */
fun main(args: Array<String>) {
    var list = listOf("aa", "bb", "cc", "dd", "ee")

    println("list filter 01 == ${list.filter { x -> x.startsWith("a") }}")
    println("list filter 02 == ${list.filter { it.startsWith("a") }}")
}