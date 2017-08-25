package com.xue.isandas

fun main(args: Array<String>) {

}

var x: Any? = "111"

val y: Any? = "123"

/**
 * 智能转换 考虑几个问题
 *
 * is关键字的作用范围
 * 当编译器不能保证变量在检查和使用之间不可改变时，智能转换不能用
 *
 *
 *
 * val 局部变量——总是可以；
 * var 局部变量——如果变量在检查和使用之间没有修改、并且没有在会修改它的 lambda 中捕获；
 * val 属性——如果属性是 private 或 internal，或者该检查在声明属性的同一模块中执行。智能转换不适用于 open 的属性或者具有自定义 getter 的属性；
 * var 属性——决不可能（因为该变量可以随时被其他代码修改
 * */
fun test1() {
    var v: Any = "asd"

    if (v is String) {
        println("v length == ${v.length}")
    }

    if (v is String && v.length > 2) {
        println("长度大于二")
    }

    if (v !is String) {
        println("v == {$v}")
    } else {
        println("v length == ${v.length}")
    }

    if (x is String) {
        println("v length == ${(x as String).length}")
    }

    if (y is String) {
        println("v length == ${y.length}")
    }
}

/**
 * “不安全的”转换操作符
 * 通常，如果转换是不可能的，转换操作符会抛出一个异常。
 * 因此，我们称之为不安全的。 Kotlin 中的不安全转换由中缀操作符 as（参见operator precedence）完成
 *
 * “安全的”（可空）转换操作符
 * 为了避免抛出异常，可以使用安全转换操作符 as?，它可以在失败时返回 null
 * */
fun test2() {
    val v1: String = y as String
    val v2: String? = x as String?
    val v3: String? = x as? String
}



