package com.xue.basic.boolean

fun main(args: Array<String>) {
    test01()
}

/**
 * 对非空集合的装箱，boolean 保持 同一性 和 相等性
 *
 * boolean运算符
 *
 * ||   短路或
 * &&   短路与
 * !    逻辑非
 * */
fun test01() {
    var boolean = true
    var boxedBoolean1: Boolean? = boolean
    var boxedBoolean2: Boolean? = boolean

    println("boxedBoolean1 === boxedBoolean2 : ${boxedBoolean1 === boxedBoolean2}")
    println("boxedBoolean1 == boxedBoolean2 : ${boxedBoolean1 == boxedBoolean2}")
}

