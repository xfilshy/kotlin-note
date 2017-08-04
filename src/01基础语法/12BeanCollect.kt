package com.xue.base.collect
/**
 * 集合的简单实用
 *
 * testCollect01 简单的集合遍历 setOf 生成的集合在迭代时是保持顺序的 有点奇怪
 * testCollect02 判断包含，没什么好说的
 * testCollect03 集合的lambda表达式运算，典型的响应式编程，漂亮 只是简单的使用，但是非常实用 ， 运算环境中的it代表遍历时的单一元素
 * */
fun main(args: Array<String>) {
    testCollect01()
    testCollect02()
    testCollect03()
}

fun testCollect01() {
    var items = setOf(3, 5, 1, 2, 3, 4, 10, 32)
    for (item in items) println("item == $item")
}

fun testCollect02() {
    var items = listOf("1", 1, "a", "23", "31")
    println("items has a ${"a" in items}")
    println("items has 1 ${1 in items}")
}

fun testCollect03() {
    var items = setOf(1, 4, 2, 5, 3, 6, 9, 8, 7, -1, "a")
    items
            .filter { it is Int && it > 0 }//筛选
            .sortedBy { it as Int }//排序
            .map { it as Int + 10 }//映射
            .forEach { println("$it") }//循环遍历

}
