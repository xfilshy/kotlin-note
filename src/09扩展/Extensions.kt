package com.xue.extensions

/**
 * Kotlin 同 C# 和 Gosu 类似，能够扩展一个类的新功能而无需继承该类或使用像装饰者这样的任何类型的设计模式。
 * 这通过叫做 扩展 的特殊声明完成。Kotlin 支持 扩展函数 和 扩展属性。
 *
 * 这个功能我觉得是kotlin里很亮眼的一个点，省去了茫茫多的继承或者工具类
 *
 *
 * */
fun main(args: Array<String>) {
    var list = mutableListOf(1, 2, 3, 4)
    println("before list : $list")
    list.swap(0, 2)
    println("after list : $list")

    println("xueliyu swap : ${"xueliyu".swap(0, 5)}")

    printFoo(D())

    var e = E()
    e.foo()

    var cc = CC()

    println(null.toString())

    println("xueliyu".frist)
}

/**
 * 这就是一个扩展函数的基本写法
 * 扩展函数基本写法
 *
 * 可见性声明 fun 扩展类型.函数名(参数){
 *      方法块
 * }
 * 和一个普通函数的写法基本完全一致
 *
 * 这个方法声明在顶级，根据可见性调用
 * 如果声明在类内部，好像就只能在类的内部调用了
 * */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    var tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun String.swap(index1: Int, index2: Int): String {
    var chars = this.toCharArray()
    var tmp = this[index1]
    chars[index1] = chars[index2]
    chars[index2] = tmp

    return String(chars)
}


/**
 * 这个例子相当的经典了
 *
 * 扩展不能真正的修改他们所扩展的类。
 * 通过定义一个扩展，你并没有在一个类中插入新成员，仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
 * 我们想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。
 * 这意味着调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的
 * */
open class C

class D : C()

fun C.foo() = "c"

fun D.foo() = "d"

fun printFoo(c: C) {
    println(c.foo())
}
//main 方法调用 printFoo(D())


/**
 * 如果一个类定义有一个成员函数和一个扩展函数，而这两个函数又有相同的接收者类型、相同的名字并且都适用给定的参数，这种情况总是取成员函数
 * */
class E {
    fun foo() {
        println("member")
    }
}

fun E.foo() {
    println("extension")
}


/**
 * 这个扩展
 * 其实只是想说明 扩展的null判断是在方法体里进行
 *
 * 在分析一下这个函数本身：
 * kotlin所有对象都Any的子类
 * Any 有 toString(),hashCode(),equals()三个方法
 * 然而 相同的函数 优先调用对象的成员函数
 * 那么这个扩展 只是为 null 服务
 * */
fun Any?.toString(): String {
    if (this == null) return "null"

    return toString()
}

/**
 * 扩展属性
 *
 * 由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。
 * 这就是为什么扩展属性不能有初始化器。他们的行为只能由显式提供的 getters/setters 定义
 * */
val String.frist: Char
    get() = this[0]


/**
 * 对伴生对象设置 扩展函数和扩展属性
 * */
class MyClass {
    companion object {}  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    // ……
}

val MyClass.Companion.flag: Int
    get() = 1


/**
 * 在一个类内部你可以为另一个类声明扩展。在这样的扩展内部，有多个 隐式接收者 —— 其中的对象成员可以无需通过限定符访问。
 * 扩展声明所在的类的实例称为 分发接收者，扩展方法调用所在的接收者类型的实例称为 扩展接收者 。
 *
 * 对于分发接收者和扩展接收者的成员名字冲突的情况，扩展接收者优先。要引用分发接收者的成员你可以使用 限定的 this 语法
 *
 *
 * */
class DD {
    fun bar() {}
}

class CC {
    fun baz() {}

    fun DD.foo() {
        bar()   // 调用 D.bar
        baz()   // 调用 C.baz
        toString() //调用DD的toString
        this@CC.toString() //调用CC的toString

    }

    fun caller(d: DD) {
        d.foo()   // 调用扩展函数
    }
}


/**
 * 声明为成员的扩展可以声明为 open 并在子类中覆盖。
 * 这意味着这些函数的分发对于分发接收者类型是虚拟的，但对于扩展接收者类型是静态的
 *
 * 解释一下吧  分发者就是C0 或 C1 ，既然扩展被继承了 ，那么他对C0和C1是多态的，所以是虚拟的
 * */
open class D0 {
}

class D1 : D0() {
}

open class C0 {
    open fun D.foo() {
        println("D.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D) {
        d.foo()   // 调用扩展函数
    }
}

class C1 : C0() {
    override fun D.foo() {
        println("D.foo in C1")
    }

    override fun D1.foo() {
        println("D1.foo in C1")
    }
}

/**
 * 扩展的动机 最大的意义在避免创建过多的工具类和工具函数，将扩展方法注入给类本身，使用和记忆都更方便
 * */