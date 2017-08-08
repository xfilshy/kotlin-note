package com.xue.control.`when`

import java.lang.Integer.parseInt


/**
 * when语句可以取代java中的switch语句
 * 基本写法
 *
 * when(判断值){
 *      状态1 -> 表达式或代码块
 *      转台2 -> 表达式或代码块
 *      else -> 默认的表达式或代码块
 * }
 *
 * when语句按顺序判断，满足的条件执行并跳出，无switch的穿透效果
 *
 * when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。
 * when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，
 * 符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。
 * （像 if 一样，每一个分支可以是一个代码块，它的值是块中最后的表达式的值。）
 *
 * 如果其他分支都不满足条件将会求值 else 分支。
 * 如果 when 作为一个表达式使用，则必须有 else 分支， 除非编译器能够检测出所有的可能情况都已经覆盖了。
 * */
fun main(args: Array<String>) {
    test02(2)
}

fun test01(color: String) {
    when (color) {
        "red" -> 1
        "blue" -> 2
        "green" -> 3
        else -> 0
    }
}

fun test02(value: Any) {
    when (value) {
        1, 2 -> println("1 , 2")
        in 1..5 -> println("in 3..5 ")
        is String -> println("is String")
        else -> println("else")
    }
}

fun test03(s: String) {
    var x = 10
    when (x) {
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
    }
}

