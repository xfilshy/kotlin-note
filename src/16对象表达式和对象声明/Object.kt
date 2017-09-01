package com.xue.`object`

fun main(args: Array<String>) {

    var door = Door()

    /**
     * 匿名内部类
     * */
    door.setOnChangeListener(object : OnChangeListener {

        override fun onOpen() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onClose() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    })

    Person.Simple.hhh = 10
    Simple.hhh = 10

    MyClass.create()
    MyClass1.create()


    var v = MyClass.Factory
    var v1 = MyClass1.Companion

    println(v)
    println(v1)

    test1()
    test2()
}

fun test1() {
    var v = MyClass.Factory
    var v1 = MyClass1.Companion

    println(v)
    println(v1)
}

fun test2() {
    var v = MyClass.Factory
    var v1 = MyClass1.Companion

    println(v)
    println(v1)
}

class Door {

    fun setOnChangeListener(listenr: OnChangeListener) {}
}

interface OnChangeListener {

    fun onOpen()

    fun onClose()
}

open class Person(open var name: String) {

    var value = 1

    /**
     * 成员变量
     * */
    private var ff = object {
        fun t() = value
    }

    /**
     * 像一个静态的对象
     * */
    object Simple {

        var hhh = 2

        fun test01() = 1
    }

    fun te() {
        Simple.test01()
        ff.t()
    }
}

interface TestInterface {
    fun test()
}

/**
 * object关键字声明带参数的内部类 ， 这个同时实现了接口，但是问题是声明类型为Person ， 那接口方法怎么调用
 * 还有内部新声明的属性怎么调用 奇怪
 *
 * 答案是 匿名函数必须在私有作用域声明 他的成员才能被访问 最直白的说法就是 private修饰  在其作用域范围内成员可见
 * */
private var prs = object : Person("11"), TestInterface {

    var nnn = 1

    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var name = "dsds"
}

/**
 * 任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写
 * 声明一个临时匿名的类对象，真个相当的方便
 * */
private var tmp = object {
    var a = 1
    var b = 2
}

/**
 * 声明对象 , 声明的位置不能是局部的  如方法内部
 * 这个对象一看就是个单例的
 * */
object Simple {

    var hhh = 2

    fun test01() = 1
}

/**
 * 伴生对象 使用 companion 声明
 * 伴生对象的调用 直接通过父类调用 不需要伴生对象的名字 所以伴生对象也可以没有名字
 * 所以一个类只能有一个伴生对象
 * */
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }

}

/**
 * 伴生对象也是一个对象 获取伴生对象  类名.伴生对象名，如果 伴生对象没有名 那就 类名.Companion
 * 不太清楚伴生对象的意义何在 感觉在build模式或者工厂模式比较有用
 * 这里看 伴生对象像是一个静态单例的
 * */
class MyClass1 {
    companion object {
        fun create(): MyClass = MyClass()
    }

}


/**
 * 对象表达式和对象声明之间的语义差异
 *
 * 对象表达式和对象声明之间有一个重要的语义差别：
 *
 * 对象表达式是在使用他们的地方立即执行（及初始化）的
 * 对象声明是在第一次被访问到时延迟初始化的
 * 伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配
 * */