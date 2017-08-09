package com.xue.inheritance

fun main(args: Array<String>) {
    var bb1 = Base1()
    bb1.varValue = 1

    println("bb1.varValue == ${bb1.varValue}")


    var ex1 = Example8()
    ex1.varValue = 1

    println("ex1.varValue == ${ex1.varValue}")
}

/**
 * 在 Kotlin 中所有类都有一个共同的超类 Any，这对于没有超类型声明的类是默认 Any 超类
 * Any 不是 java.lang.Object；尤其是，它除了 equals()、hashCode()和toString()外没有任何成员
 *
 * 1.继承不管是在主构造函数或者次级构造函数，都必须至少实现超类的一个构造函数
 * 2.override关键字修饰的方法默认为open的 需要final关闭
 * */
class Example


open class Base(value: Int) {

    constructor(value: Int, data: String) : this(value)

}

/**
 * 类上的 open 标注与 Java 中 final相反，它允许其他类从这个类继承
 * 默认情况下，在 Kotlin 中所有的类都是 final
 * 与 Java 不同，Kotlin 需要显式标注可覆盖的成员（我们称之为开放）和覆盖后的成员
 * "要么为继承而设计，并提供文档说明，要么就禁止继承"这个和java相反的设计 好像更符合逻辑
 * */
open class Base1() {

    open var varValue: Int = 0
        get() = field
        set(value) {
            field = value
        }

    open val valValue: Int = 0
        get() = field

    constructor(value: Int) : this()
    constructor(value: Int, data: String) : this()

    open fun funcation1() = 1
    open fun funcation2() {
        println("println Base1 funcation2")
    }
}

open class Base2


/**
 * 如果该类有一个主构造函数，其基类型可以（并且必须） 用（基类型的）主构造函数参数就地初始化
 * */
class Example1(value: Int) : Base(value)

/**
 * 也可实现超类的次级构造函数，因为次级构造函数都是托管给主构造函数的
 * */
class Example2(value: Int, data: String) : Base(value, data)

/**
 * 超类有主构造函数 子类可以没有
 * */
class Example3 : Base {
    constructor(value: Int) : super(value)
}

/**
 * 超类没有主构造函数，有次级构造函数 子类需要委托
 * */
class Example4 : Base1 {
    constructor(value: Int) : super(value)
}

/**
 * 超类没有声明构造函数，子类实际还是委托给了默认的构造函数
 * */
class Example5 : Base2()

class Example6 : Base2 {
    constructor()
}

/**
 * 标记为 override 的成员本身是开放的，也就是说，它可以在子类中覆盖。如果你想禁止再次覆盖，使用 final 关键字
 * */
class Example7 : Base1() {
    override fun funcation1() = 2
    override fun funcation2() {
        super.funcation2()
    }
}

/**
 * 属性覆盖与方法覆盖类似；
 * 在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型。
 * 每个声明的属性可以由具有初始化器的属性或者具有 getter 方法的属性覆盖
 *
 * 属性重新是 val可以改写为var 但是var不能改写成val 原理很简单，子类要满足父类的set方法
 *
 * Example8 和 Example9 的效果完全一致
 * */
class Example8 : Base1() {

    override var varValue: Int = 0

    override var valValue: Int = 0
}

class Example9(override var varValue: Int, override val valValue: Int) : Base1()

/**
 * super 调用超类函数和属性访问器实现
 * */
class Example10() : Base1() {

    override var varValue: Int = 0
        get() = super.varValue

    override fun funcation2() {
        super.funcation2()

        println("println Example9 funcation2")
    }
}


/**
 * 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@引用目标类
 * */
class Example11 : Base1() {

    override var varValue: Int
        get() = super.varValue
        set(value) {
            super.varValue = value
        }

    override fun funcation1(): Int {
        return super.funcation1()
    }

    override fun funcation2() {
        super.funcation2()
    }

    inner class Baz {
        fun g() {
            super@Example11.funcation1() // 调用 Foo 实现的 f()
            println(super@Example11.varValue) // 使用 Foo 实现的 x 的 getter
        }
    }
}

/**
 * 在 Kotlin 中，实现继承由下述规则规定：
 * 如果一个类从它的直接超类继承相同成员的多个实现， 它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。
 * 为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super，如 super<Base>
 *
 * 同时继承 A 和 B 没问题，并且 a() 和 b() 也没问题因为 C 只继承了每个函数的一个实现。
 * 但是 f() 由 C 继承了两个实现，所以我们必须在 C 中覆盖 f() 并且提供我们自己的实现来消除歧义
 * */
open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } // 接口成员默认就是“open”的

    fun b() {
        print("b")
    }
}

/**
 * A 和 B中有完全相同的方法f ， 这种情况必须重新
 * */
class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调用 A.f()
        super<B>.f() // 调用 B.f()
    }
}

/**
 * 这套写法 三观尽毁
 *
 * 超类 实现了方法 f  子类可以把f变成抽象方法
 * */
open class Base4 {
    open fun f() {
        println("sdasd")
    }
}

abstract class Derived : Base4() {
    override abstract fun f()
}


/**
 * 伴生对象
 *
 * 与 Java 或 C# 不同，在 Kotlin 中类没有静态方法。在大多数情况下，它建议简单地使用包级函数。
 *
 * 如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的函数（例如，工厂方法），你可以把它写成该类内对象声明中的一员。
 *
 * 更具体地讲，如果在你的类内声明了一个伴生对象， 你就可以使用像在 Java/C# 中调用静态方法相同的语法来调用其成员，只使用类名作为限定符。
 * */