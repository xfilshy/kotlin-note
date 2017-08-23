package com.xue.inline.function

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock

fun main(args: Array<String>) {
    var l = L()
//    lock(l) {
//        foo()
//        return
//    } //flag1
//    lock(l) { 1 + 2 }
    lock(l, ::foo)

    foo2()

    hasZerosFanyi1(listOf(1, 2, 3, 0, 2, 4))
    hasZerosFanyi2(listOf(1, 2, 3, 0, 2, 4))
}

class L : Lock {
    override fun lock() {
    }

    override fun tryLock(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun tryLock(time: Long, unit: TimeUnit?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unlock() {
    }

    override fun lockInterruptibly() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun newCondition(): Condition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun foo(): String {
    return "foo"
}


/**
 * 对这个内联函数我的理解就是
 *
 * 都传入的函数参数 正常的情况下 传入了一个 lambda表达式会不系统编译成一个匿名的函数对象被传入 但是如果是内联的调用 就直接调用了表达式内部 没有生产函数对象
 *
 * 例如 flag1 的地方
 *
 * 如果不是内联函数  传入的 { foo() } ，编译器会先生成一个  匿名函数 f 指向 { foo() } ，然后把 f 传给lock函数使用
 * 如果是内联函数    传入的 { foo() } ，编译器不会生成匿名函数f，而是直接将 foo函数 传给 lock使用
 *
 * 这是我个人的理解
 * */
inline fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

fun ordinaryFunction(body: () -> Unit) {

}

inline fun inlineFunction(body: () -> Unit): String {
    var v = body()

    println("inlineFunction value = $v")

    return "123"
}


/**
 * 我们可以只使用一个正常的、非限定的 return 来退出一个命名或匿名函数。
 * 这意味着要退出一个 lambda 表达式，我们必须使用一个标签，并且在 lambda 表达式内部禁止使用裸 return，因为 lambda 表达式不能使包含它的函数返回
 * 但是如果 lambda 表达式传给的函数是内联的，该 return 也可以内联
 * 这种返回（位于 lambda 表达式中，但退出包含它的函数）称为非局部返回
 * */
fun foo1() {
    println("foo1 in")

    ordinaryFunction {

        println("ordinaryFunction return before")

//        return // 错误：不能使 `foo` 在此处返回

        println("ordinaryFunction return after")
    }

    println("foo1 out")

}

fun foo2() {
    println("foo2 in")

    inlineFunction {
        println("inlineFunction return before")

        return // OK：该 lambda 表达式是内联的

        println("inlineFunction return after")

    }

    println("foo2 out")
}

/**
 * 这是常用的使用方式 请注意 forEach函数就是内联函数
 * 这里看就更明显了  实际就是把  内联函数中传入的lambda表达式直接注入的所在函数的感觉
 * */
fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true // 从 hasZeros 返回
    }
    return false
}

/**
 * 上面的函数就可以直接翻译为这个样子
 * */
fun hasZerosFanyi(ints: List<Int>): Boolean {
    for (i in ints) {
        if (i == 0) return true// 从 hasZeros 返回
    }
    return false
}

fun hasZerosFanyi1(ints: List<Int>): Boolean {
    for (i in ints) {
        if (i == 0) break // 从 hasZeros 返回
        println("i == $i")
    }
    return false
}

fun hasZerosFanyi2(ints: List<Int>): Boolean {
    for (i in ints) {
        if (i == 0) continue // 从 hasZeros 返回
        println("i == $i")
    }
    return false
}


/**
 * 请注意，一些内联函数可能调用传给它们的不是直接来自函数体、而是来自另一个执行上下文的 lambda 表达式参数，例如来自局部对象或嵌套函数。
 * 在这种情况下，该 lambda 表达式中也不允许非局部控制流。为了标识这种情况，该 lambda 表达式参数需要用 crossinline 修饰符标记
 *
 * 没看懂 感觉和闭包很像的声明
 * */
inline fun f(crossinline body: () -> Unit) {
    val f = object : Runnable {
        override fun run() = body()
    }

    f.run()
}

fun ff(body: () -> Unit) {
    val f = object : Runnable {
        override fun run() = body()
    }

    f.run()
}

/**
 * 这里的两种调用 好像又违背了刚才注入的说法
 * 其实没有 很简单  你把内联函数 以注入的形式写一下就知道了
 * */
fun testF() {
    f {
        println("123")

//        return

        println("321")
    }
}

fun testFF() {
    ff {
        println("123")

//        return

        println("321")
    }
}

/**
 * 这个是翻译 内联函数 你看return对 函数testF 无效是对的嘛
 * */
fun testFFanyi() {

    val f = object : Runnable {
        override fun run() {
            println("123")
            return
            println("321")
        }
    }

    f.run()
}

class Foo

class Bar


/**
 * 内联属性 搞不懂是个什么鬼
 * */
class A {
//    val foo: Foo
//        inline get() = Foo()
//
//    var bar: Bar
//        inline get() = Bar()
//        inline set(value) {
//            field = value
//        }
//
//    inline var bar1: Bar
//        get() = Bar()
//        set(value) {
//            field = value
//        }
}
