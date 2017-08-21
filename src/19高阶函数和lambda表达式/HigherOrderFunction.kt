package com.xue.higherfunction

import javax.print.attribute.standard.MediaSize

fun main(args: Array<String>) {
    /**
     * t1 和 t12 这两种调用方式都是合法的，第一种是标准的 第二中在函数参数在参数的最后，且传入的是lambda表达式的情况可以第二种写法
     * 如果唯一参数是函数，且调用时是lambda表达式，可以连圆括号都省略
     * */
    var t1 = test1(12, { value: Int -> "dasda" + value })
    var t12 = test1(12) { value: Int -> "dasda" + value }
    var t2 = test2()

    println("t1 = $t1")
    println("t2 = $t2")
    println("t2() = ${t2(10)}")

    test3(::test4)

    var strings = arrayOf("3123", "31da", "d", "2fsfq", "eqeqe11")
    var m = max(strings, { a, b -> a.length < b.length })

    println("max == $m")

    test5()
    test7()
}

/**
 * 高阶函数是将函数用作参数或返回值的函数。
 *
 * test1 为参数为函数
 * test2 为返回值为函数
 *
 * 注意这里函数的写法 都是 lambda 表达式
 * 基本声明方式就  (参数) -> 返回值  这样就基本描述了一个函数
 * */
fun test1(value: Int, t: (value: Int) -> String) {
    println("function t value ${t(value)}")
}


fun test2(): (value: Int) -> String {
    return { value: Int -> "adadssa" + value }
}

/**
 * 注意test3 对 test4的引用 用到了函数引用 反射相关 暂时只写这个
 * 如果非同级的函数引用 如果 我要引用一个对象的函数 暂时我们先不管
 * */
fun test3(f: () -> String) {

}

fun test4(): String {
    return "adasda"
}

class A {
    fun test(): String = ""
}

/**
 * Lambda 表达式在下文会有更详细的描述，但为了继续这一段，让我们看一个简短的概述：
 *
 * lambda 表达式总是被大括号括着，其参数（如果有的话）在 -> 之前声明（参数类型可以省略），函数体（如果存在的话）在 -> 后面。
 *
 * 在 Kotlin 中有一个约定，如果函数的最后一个参数是一个函数，并且你传递一个 lambda 表达式作为相应的参数，你可以在圆括号之外指定它
 * */


/**
 * 自行实现了一下 List的map函数
 * */
fun <T, R> List<T>.mapping(f: (t: T) -> R): List<R> {
    val ll = arrayListOf<R>()

    for (t in this)
        ll.add(f(t))

    return ll
}

/**
 * 增强版的mapping 注意看看调用
 * */
fun <T, R> List<T>.mapping2(f: (t: T, s: String) -> R): List<R> {
    val ll = arrayListOf<R>()

    for (t in this)
        ll.add(f(t, "123"))

    return ll
}

fun test() {
    var list = listOf(1, 2, 3)

    list.mapping2 { t, s -> "$t$s" }

    // 另一个有用的约定是，如果函数字面值只有一个参数， 那么它的声明可以省略（连同 ->），其名称是 it
    list.mapping { it + 1 }
    // 这个是一个比较标准的
    list.mapping { value -> "String value $value" }

    var map = mapOf(1 to "1", 2 to "2")
    //下滑线可以来替代lambda表达式中没用到的参数
    map.forEach { _, value -> println("$value!") }
}

fun max(strings: Array<String>, f: (String, String) -> Boolean): String {
    var value = ""
    strings.forEach { if (f(value, it)) value = it }

    return value
}

/**
 * sum1 和 sum2 是完全一样的  还是类型的自动推断
 * */
val sum1: (Int, Int) -> Int = { a, b -> a + b }
val sum2 = { a: Int, b: Int -> a + b }

/**
 * 5种表达都是一样的
 *
 * 后两种是匿名函数
 *
 * Lambda表达式和匿名函数之间的另一个区别是非局部返回的行为。一个不带标签的 return 语句总是在用 fun 关键字声明的函数中返回。
 * 这意味着 lambda 表达式中的 return 将从包含它的函数返回，而匿名函数中的 return 将从匿名函数自身返回。
 * */
fun test1() {
    var ints = arrayOf(1, 2, 3, 4)

    ints.filter {
        it > 0
    }

    ints.filter {
        val shouldFilter = it > 0
        shouldFilter
    }

    ints.filter {
        val shouldFilter = it > 0
        return@filter shouldFilter
    }

    ints.filter(fun(x: Int) = x > 0)

    ints.filter(fun(x: Int): Boolean { return x > 0 })
}

/**
 * Lambda 表达式或者匿名函数（以及局部函数和对象表达式） 可以访问其 闭包 ，即在外部作用域中声明的变量。 与 Java 不同的是可以修改闭包中捕获的变量
 * */
fun test3() {
    var ints = arrayOf(1, 2, 3, 4)

    var sum = 0
    ints.filter { it > 0 }.forEach {
        sum += it
    }

    print(sum)
}

/**
 * 带接收者的函数字面值
 *
 * 很难看懂
 * */
class HTML {
    fun body() {}
}

fun HTML.tt() {}

val sum: Int.(Int) -> Int = { other: Int -> this + other }

/**
 * 写一下基本理解吧
 *
 * 这里的HTML其实是什么呢 ，他是描述的是传入函数额调用对象 this
 * 就是你在传入函数中引用到的this引用
 * */
fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()  // 创建接收者对象
    println("init == $init")
    html.init()        // 将该接收者对象传给该 lambda
    return html
}

fun test5() {
    html {
        // 带接收者的 lambda 由此开始
        body()   // 调用该接收者对象的一个方法
    }

    html { ->
        tt()   // 调用该接收者对象的一个方法
    }

    html {
        ->
        println(this)   // 调用该接收者对象的一个方法
    }
}

fun test6(other: Int, sum: Int.(Int) -> Int) {
    println(1.sum(other))
}

fun test7() {
    val sum = fun Int.(other: Int) = this + other
    test6(2, sum)
    test6(2, fun Int.(other: Int) = this + other)

    val sum2: Int.(Int) -> Int = { other -> this + other }
    test6(2, sum2)
}