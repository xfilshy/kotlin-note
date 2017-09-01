package com.xue.aliases

import java.io.File
import javax.xml.soap.Node

fun main(args: Array<String>) {
    var a1 = A().Inner()
    var a2 = A.AA()

    println("a1 == $a1")
    println("a2 == $a2")

    var a22 = AAA()
}

/**
 * 这两个是例子 这个例子用的比较不明显
 * */
typealias NodeSet = Set<Node>

typealias FileTable<K> = MutableMap<K, MutableList<File>>



/**
 * 这个比较明显了吧
 *
 * 声明一个 StringList的类型别名 去替代 ArrayList<String> 方便引用 其实主要看着比较装逼 实用意义不怎么大
 * */
typealias StringList = ArrayList<String>

fun test1() {
    var sl = StringList()
}

/**
 * 这个还是有一点实用意义的 ，有类型别名去替代一个 比较复杂的 函数类型声明
 * */
typealias funcation1 = () -> Boolean

class A {
    inner class Inner {
        val cc = 0
    }

    class AA
}

class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias AAA = A.AA
typealias BInner = B.Inner

fun test2() {

}


/**
 * 类型别名不会引入新类型。
 * 它们等效于相应的底层类型。
 * 当你在代码中添加 typealias Predicate<T> 并使用 Predicate<Int> 时，Kotlin 编译器总是把它扩展为 (Int) -> Boolean。
 * 因此，当你需要泛型函数类型时，你可以传递该类型的变量，反之亦然
 * */
typealias funt<T> = (T) -> Boolean


