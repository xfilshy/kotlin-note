package com.xue.equality

/**
 * 相等性
 *
 * 引用相等（两个引用指向同一对象）
 * 结构相等（用 equals() 检查）
 * */
fun main(args: Array<String>) {
    test1()
}

data class Test(var v: Int)

/**
 * 引用相等由 ===（以及其否定形式 !==）操作判断。a === b 当且仅当 a 和 b 指向同一个对象时求值为 true。
 * 结构相等由 ==（以及其否定形式 !=）操作判断。按照惯例，像 a == b 这样的表达式会翻译成 a?.equals(b) ?: (b === null)
 *
 * 引用相等不赘述 就是 引用地址相等
 * 结构相等 依赖于 equals函数 == 只是做了对空对象的处理  所以在java中的 equals的使用 在kotlin中 == 更实用
 *
 * a == null 会被自动转换为 a=== null 这个其实没什么好说的 null是不具有equals函数的
 * */
fun test1() {
    var t1 = Test(1)
    var t2 = Test(1)
    var t3 = t1

    println("t1 === t2 : ${t1 === t2}")
    println("t1 === t3 : ${t1 === t3}")
    println("t1 == t2 : ${t1 == t2}")
    println("t1 == t3 : ${t1 == t3}")
}