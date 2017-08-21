package com.xue.delegation

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived(b).print() // 输出 10
    Derived(b).print1() // 输出 10

    println("s = $s")

    s = "123123"

    observableValue = "xue"
    observableValue = "liyu"

    vetoableValue = "xue"
    println("wai vetoableValue == $vetoableValue")

    vetoableValue = "liyu"
    println("wai vetoableValue == $vetoableValue")

}

interface Base {
    fun print()
    fun print1()
}

class BaseImpl(val x: Int) : Base {
    override fun print1() {
        println("厄齐尔群二")
    }

    override fun print() {
        println(x)
    }
}

/**
 * 类委托，一种很实用的设计模式
 *
 * 比如  我现在有个 http请求器 但是我的内部实际上是没有做任何实现的
 * 所以 我可以把请求的实现委托给其他的对象去完成
 *
 * 委托的对象只会覆盖 未实现的方法
 * */
class Derived(b: Base) : Base by b {
    override fun print1() {
        println("31231")
    }
}

/**
 * 不需要一定 实现 ReadWriteProperty ，但是方法一定要对的上 固定的
 * */
var s: String by AAA()

class AAA {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class A {
    /**
     * 两种实现
     * p1 委托给了函数 函数返回实现的对象
     * p2 委托给了类
     * val/var <属性名>: <类型> by <表达式>。
     * 在 by 后面的表达式是该 委托， 因为属性对应的 get()（和 set()）会被委托给它的 getValue() 和 setValue() 方法。
     * 属性的委托不必实现任何的接口，但是需要提供一个 getValue() 函数（和 setValue()——对于 var 属性）
     * 当我们从委托到一个 Delegate 实例的 p 读取时，将调用 Delegate 中的 getValue() 函数， 所以它第一个参数是读出 p 的对象、第二个参数保存了对 p 自身的描述 （例如你可以取它的名字)。
     * */
    var p1: String by Dl1()
    var p2: String by Dl2()

    private fun Dl1(): ReadWriteProperty<A, String> {
        return object : ReadWriteProperty<A, String> {
            override fun getValue(thisRef: A, property: KProperty<*>): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun setValue(thisRef: A, property: KProperty<*>, value: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }


    class Dl2 : ReadWriteProperty<A, String> {
        override fun getValue(thisRef: A, property: KProperty<*>): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setValue(thisRef: A, property: KProperty<*>, value: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}

/**
 * 延迟初始化  只能用来初始化 val 不可变变量
 *
 * 默认情况下，对于 lazy 属性的求值是同步锁的（synchronized）：
 * 该值只在一个线程中计算，并且所有线程会看到相同的值。
 * 如果初始化委托的同步锁不是必需的，这样多个线程可以同时执行，那么将 LazyThreadSafetyMode.PUBLICATION 作为参数传递给 lazy() 函数。
 * 而如果你确定初始化将总是发生在单个线程，那么你可以使用 LazyThreadSafetyMode.NONE 模式， 它不会有任何线程安全的保证和相关的开销
 * */
val lazyValue: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
    println("第一次调用时才初始化")
    "value"
}


/**
 * 试了几次 好像不能为空啊
 * prop 是这个  KProperty<*>   old 之前的值   new 新的值
 * 这个是能够监听到值得变化 好像不能再赋值前截获
 * */
var observableValue: String by Delegates.observable("") { prop, old, new ->
    println("porp == $prop")
    println("old == $old")
    println("new == $new")
    println("observableValue == $observableValue")
}

/**
 * 这个其实和observable用法基本一致  差别 在于 lambda表达式的返回值是boolean的 false将不赋值 true才赋值
 * */
var vetoableValue: String by Delegates.vetoable("") { property, oldValue, newValue ->
    println("porp == $property")
    println("old == $oldValue")
    println("new == $newValue")
    println("vetoableValue == $vetoableValue")

    "xue" != newValue
}


/**
 * 把属性储存在映射中
 *
 * 一个常见的用例是在一个映射（map）里存储属性的值。 这经常出现在像解析 JSON 或者做其他“动态”事情的应用中。
 * 在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。
 *
 * 两个例子 分别代表了 可变属性 和 不可变属性
 * */
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun initUser() {
    var user = User(mapOf(
            "name" to "sds",
            "age" to 12
    ))
}

class MutableUser(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int     by map
}

fun initMutableUser() {
    var user = MutableUser(mutableMapOf(
            "name" to "sds",
            "age" to 12
    ))
}


/**
 * 局部变量委托 ， example传入了一个真实的委托表达式
 * */
class Foo {
    fun isValid(): Boolean {
        return true
    }

    fun doSomething() {}
}

var someCondition = true

fun example(computeFoo: () -> Foo) {
    val memoizedFoo: Foo by lazy(computeFoo)

    if (someCondition && memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
}

fun test() {
    example { -> Foo() }
}

/**
 *
 * 属性委托要求
 *
 * 这里我们总结了委托对象的要求。
 *
 * 对于一个只读属性（即 val 声明的），委托必须提供一个名为 getValue 的函数，该函数接受以下参数：
 *
 * thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型，
 * property —— 必须是类型 KProperty<*> 或其超类型，
 * 这个函数必须返回与属性相同的类型（或其子类型）。
 *
 * 对于一个可变属性（即 var 声明的），委托必须额外提供一个名为 setValue 的函数，该函数接受以下参数：
 *
 * thisRef —— 同 getValue()，
 * property —— 同 getValue()，
 * new value —— 必须和属性同类型或者是它的超类型。
 * getValue() 或/和 setValue() 函数可以通过委托类的成员函数提供或者由扩展函数提供。
 * 当你需要委托属性到原本未提供的这些函数的对象时后者会更便利。 两函数都需要用 operator 关键字来进行标记。
 *
 * 委托类可以实现包含所需 operator 方法的 ReadOnlyProperty 或 ReadWriteProperty 接口之一。
 *
 *
 * 委托先到这里吧
 * */