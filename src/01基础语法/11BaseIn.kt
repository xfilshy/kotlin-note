package com.xue.base.`in`

/**
 * in关键字 顺便说明下 a .. b 类型是 Range
 *
 * testIn01 测试数字区间判断
 *      x in a .. b 大致可以理解为（a < b）的情况 x >= a && x <= b ，如果a > b ，编译和执行都不报错，但是什么情况的返回false
 *      细节：a和b一定是同类型数据 如都是float ，都是int ，个人感觉 x ，a ，b三个的类型应该是一致的 有自动转换的嫌疑，有待研究
 *      !in的判断逻辑就是正常的反条件，不赘述
 *
 * testIn02 测试集合内判断 简单易懂不赘述 !in也是
 *
 * testIn03 测试区间迭代 实际就是有限集合迭代 没什么神奇的 重点就在 有限两个字上
 *
 * in关键字说几句吧 其实很简单 在条件语句中 in 做的是判断操作，比如判断是否包含，返回boolean ， 在循环语句或遍历场景是 做遍历操作
 * */
fun main(args: Array<String>) {
    testIn01()
    testIn02()
    testIn03()
}

fun testIn01() {
    println("10 in 1 .. 10 ${10 in 1..10}")
    println("1 in 1 .. 10 ${1 in 1..10}")
    println("1.1 in 1 .. 10 ${1.1 in 1..10}")
    println("0 in 1 .. 10 ${0f in 1..10}")
    println("13.1 in 1 .. 10 ${13.1f in 1..10}")
    println("13.1 in 1 .. 10 ${3 in 10..1}")
}

fun testIn02() {
    var list = listOf("a", "b", "c")

    println("a in list ${"a" in list}")
}

fun testIn03() {

    for (element in 1..5) {
        println("elemnt = $element")
    }

    for (element in 'A'..'z') {
        print("$element , ")
    }
    println()

    for (element in 1..10 step 3) print("$element , ")

    println()

    for (element in 10 downTo 0 step 3) print("$element , ")

    println()

    for (element in 'a'..'z' step 3) print("$element , ")
}

