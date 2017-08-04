package com.xue.define.funcation

/**
 * 函数的基本接口  fun 函数名(参数) : 返回值类型 {}，但是有很多简略写法
 *
 * fun01 和 fun02 和 fun03 实际上是完全一样的函数
 *
 * fun01是完整写法
 * fun02表达式作为函数体，特点函数体可以用一条语句完成，表达式的结果就是函数的返回值
 * fun03省略了函数返回值类型，由表达式推断
 *
 * fun04 和 fun05 是完全一样的函数
 *
 * 返回类型Unit，实际就是java中的void返回，无返回值，可以省略
 * */
fun fun01(a: Int, b: Int): Int {
    return a + b
}

fun fun02(a: Int, b: Int): Int = a + b

fun fun03(a: Int, b: Int) = a + b

fun fun04(): Unit {

}

fun fun05() {

}