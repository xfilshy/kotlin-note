package com.xue.basic.Array

/**
 * kotlin 中数组由 Array类表示 get和set方法被[]运算符重载
 *
 *
 * 注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。
 * 这意味着 Kotlin 不让我们把 Array<String> 赋值给 Array<Any>，
 * 以防止可能的运行时失败（但是你可以使用 Array<out Any>, 参见类型投影）。这一点先不细看了
 *
 * Kotlin 也有无装箱开销的专门的类来表示原生类型数组:
 * ByteArray、 ShortArray、IntArray 等等。
 * 这些类和 Array 并没有继承关系，但是它们有同样的方法属性集。它们也都有相应的工厂方法
 * */
fun main(args: Array<String>) {
    test01()
}

/**
 * 我们可以用库函数arrayOf()来创建一个有初始值的数组
 * 也可以用库函数arrayOfNulls()来创建一个指定大小，元素为空的数组
 * 还可以Array(大小，工厂函数)来构建和初始化一个数组
 * 数组创建完成后，数组大小就固定了 可以通过 + 来增加元素，但是是在原有数组基础上增加元素创建的新数组
 * */
fun test01() {
    var array = arrayOf(1, 2, 3)
    var array2 = arrayOfNulls<Any>(10)
    var array3 = Array(5, { index -> index + 10 })

    array = array + 20

    array.forEach { x -> print("$x ,") }
    println()
    array2.forEach { x -> print("$x ,") }
    println()
    array3.forEach { x -> print("$x ,") }
}

