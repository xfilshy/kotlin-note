package com.xue.function


fun main(args: Array<String>) {
    var v = 1 add 1

    println("v = $v")

    var a = A()

    v = a add 2

    println("v = $v")

    var c = C()
    c.test()

    var l = asList<String>("1", "2", "3", v = "2")
}


/**
 * 一个最常规的函数声明
 *
 * fun 函数名(参数) : 返回值 {
 *      函数块
 * }
 *
 * 参数可以没有
 * 返回值 Unit 可以省略
 * */
fun test(value: String): String {
    return ""
}


/**
 * infix fun 不知道具体叫法 先交中缀函数 必须满足
 *
 * infix修饰
 * 是扩展函数或者成员函数
 * 参数只有一个
 * */
infix fun Int.add(value: Int): Int {
    return this + value
}

class A {

    infix fun add(value: Int): Int {
        return value + 1
    }
}

/**
 * 复写有默认参数的函数，是不能再设置默认参数的，因为父类函数的默认值是生效的
 * */
open class B {
    open fun test(value: Int = 10) {
        println("value = $value")
    }
}

class C : B() {
    override fun test(value: Int) {
        super.test(value)
    }
}

/**
 * 函数调用时，参数可以按名字指定赋值 ，对参数赋值的函数或者有默认值得函数使用时比较方便
 * */
fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
    TODO()
}

/**
 * 单表达式函数 简单粗暴  函数式的结果就是返回值
 * */
fun getV(i: Int) = 2 * i


/**
 * 可变数量的参数 这个参数通常都放在最后的位置
 * 举例一个放在最后的麻烦事情
 * */
fun <T> asList(vararg ts: T, v: String): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}


/**
 * 局部函数 就是函数内部声明的函数，内部函数可以访问外部函数的局部变量
 * */
fun test() {
    var x = 2
    fun innerTest() {
        x += 1
    }
    innerTest()
    println("x == $x")
}

/**
 * 尾递归函数
 *
 * tailrec 修饰符的条件的话，
 * 函数必须将其自身调用作为它执行的最后一个操作。
 * 在递归调用后有更多代码时，不能使用尾递归，
 * 并且不能用在 try/catch/finally 块中
 * */
tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))