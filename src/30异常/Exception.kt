package com.xue.exception


fun main(args: Array<String>) {

}

/**
 * Kotlin 中所有异常类都是 Throwable 类的子孙类。 每个异常都有消息、堆栈回溯信息和可选的原因。
 * */

class MyException(message: String?, throwable: Throwable?) : Throwable(message, throwable) {

    override var message: String? = null

    init {
        this.message = message
    }

    constructor() : this(null, null)
}

/**
 * try 语句简单写法 和java一样
 * */
fun test1() {
    try {

    } catch (e: Exception) {

    } finally {

    }
}

fun String.parseInt(): Int {
    return Integer.parseInt(this)
}

/**
 * 表达式形式 可以返回值  finally 块中的内容不会影响表达式的结果。
 * */
fun teat2(input: String) {
    val a: Int? = try {
        input.parseInt()
    } catch (e: NumberFormatException) {
        null
    } finally {

    }
}

/**
 * Kotlin 没有受检的异常。这其中有很多原因，但我们会提供一个简单的例子。
 *
 * 什么是受检的异常 java代码编译时经常提示有异常抛出 必须要处理 这就是收件人的异常
 * 而kotlin没有 因为这样的
 * */

/**
 * throw 为无返回 Noting
 * */
fun test3(): Nothing {
    throw IllegalAccessException()
}