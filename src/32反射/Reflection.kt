package com.xue.reflection

import java.util.ArrayList
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction1
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

fun main(args: Array<String>) {
    println("mcClass === myClass : ${mcClass === myclass}")

    println("compose(::ff , ::gg)(1) = ${compose(::ff, ::gg)(1)}")

    test8()
}

fun fuck() {
    println()
}

fun fuck(int: Int): String {
    return ""
}

class MyClass {
    companion object {
        val TAG = "MyClass"
    }

    fun test() {
        println()
    }

    fun test(msg: String): String {
        println()
        return ""
    }
}

var mc = MyClass()

/**
 * kotlin class类引用 KClass
 * */
val myclass: KClass<MyClass> = MyClass::class

/**
 * mcClass === myClass 是引用相等的 也就是 KClass引用是单例的
 * */
var mcClass = mc::class

/**
 * java class类引用 Class
 * */
val myclassJava: Class<MyClass> = MyClass::class.java


/**
 * me1 和 me2 完全一样
 * me3 和 me4 完全一样
 * me4 和 me5 完全一样
 *
 * 对应重载的函数 ， :: 会自动匹配类型
 * */
val me1: KFunction1<MyClass, Unit> = MyClass::test

val me2: MyClass.() -> Unit = MyClass::test

/**
 * 外部引用 不是同级 怎么用KFunction的形式表达呢
 * */
//val me11: KFunction<@ParameterName(name = "msg") String, Unit> = MyClass::test

val me22: MyClass.(String) -> String = MyClass::test

val me3: KFunction1<@ParameterName(name = "int") Int, String> = ::fuck

val me4: (Int) -> String = ::fuck

val me5: () -> Unit = ::fuck

val me6: KFunction<Unit> = ::fuck


/**
 * 函数组合
 * */
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun gg(int: Int): Int {
    return 10 + int
}

fun ff(int: Int): String {
    return "to string $int"
}


/**
 * 这样这样的一个实例
 *
 * 泛型函数的反射，需要把泛型明确后 才能反射成功 是不是很他妈屌
 * */
fun <A, B> t(a: A, c: A): B? {
    return null
}

var tFun: (Int, Int) -> String? = ::t

var composeFun: ((Int) -> String, (Int) -> Int) -> ((Int) -> String) = ::compose


/**
 * 基本的同级 属性反射
 * */
var x1 = 1
val x2 = 1

fun test1() {
    var px1 = ::x1
    var px2 = ::x2

    px1.set(2)
    println("px1.get() == ${px1.get()}")

    println("px2.get() == ${px2.get()}")
}

/**
 * 函数成员属性的反射
 * */
class A(v: Int) {
    var value = v
}

fun test2() {
    var pvalue = A::value

    val a = A(10)

    pvalue.set(a, 20)

    println("pvalue.get(a) == ${pvalue.get(a)}")
}

/**
 * 伴生对象的属性反射
 * */
class B {
    companion object {
        var cov = 1
    }
}

fun test3() {
    var pcov = B.Companion::cov
}

/**
 * 扩展属性 的 反射
 * */
val String.last: Char
    get() = this[length - 1]

fun test4() {
    var plast = String::last
}

/**
 * 获取kotlin类的 java反射引用
 * */
fun test5() {
    var vg = A::value.javaGetter
    var vf = A::value.javaField

    println("A value getter == $vg")
    println("A value Filed == $vf")
}

/**
 * 获取java类的 kotlin反射引用
 * */
fun test6() {
    var al: ArrayList<String> = ArrayList()
    var alr = al.javaClass
    var kalr = alr.kotlin

    var aClass = A::class.java
    var aaClass = ArrayList::class.java

}

class C() {

    constructor(value: Int) : this() {

    }

    constructor(value: Int, msg: String) : this(value) {

    }
}

/**
 * 反射构造方法的引用
 * */
fun test7() {
    var cc1: () -> C = ::C
    var cc2: (Int) -> C = ::C
    var cc3: (Int, String) -> C = ::C
}

class D(val msg: String) {

    fun print() {
        println("msg == $msg")
    }
}

/**
 * 这里要说的就是 Dp 和 Dop这两个例子的差别了
 *
 * 一个反射的是class的函数 一个反射的是对象的函数
 *
 * 他们是完全不一样的
 *
 * 简单的说  对象的方法调用相当于对象本身调用  类的方法需要指定执行的对象
 *
 * 所以从对象反射的 函数和属性 是与对象绑定的
 * */
fun test8() {
    val numberRegex = "\\d+".toRegex()
    println(numberRegex.matches("29")) // 输出“true”

    val isNumber = numberRegex::matches
    println(isNumber("29")) // 输出“true”

    val Dp = D::print
    val Dop = D("xueliyu")::print

    Dp(D("给对象"))
    Dop()
}