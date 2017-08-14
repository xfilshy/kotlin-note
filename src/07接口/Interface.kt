package com.xue.`interface`

/**
 * Kotlin 的接口与 Java 8 类似，既包含抽象方法的声明，也包含实现
 * 与抽象类不同的是，接口无法保存状态。它可以有属性但必须声明为抽象或提供访问器实现。
 *
 * Kotlin中的接口可以提供实现了的方法，其实这就间接的出现了多继承的问题，所以比如相同方法，相同属性的冲突，
 * 子类都需要重写，明确实现方式，来回避这样的冲突
 * */
fun main(args: Array<String>) {
    var s1 = Example01()
    s1.field01 = 1
    println("s1.field01 == ${s1.field01}")

    s1.field02 = 1
    println("s1.field02 == ${s1.field02}")
}

interface Base {

    /**
     * 声明属性,是抽象的，不可以赋值，不可以操作，不能引用
     * */
    var field01: Int

    val field11: Int

    var field02: Int
        get() = field01
        set(value) = println("啥意思")

    val field03: String
        get() = "以后接口的静态常量是这样么，我醉了，肯定换实现方式了"

    fun funcation01()

    /**
     * 可以实现，是不是很不一样
     * 我们来想想一下他的使用空间
     * interface是用来描述能干什么的，那可以实现的方法，可以是一个干什么的默认实现，或者是干什么过程的公共子环节的描述
     * */
    fun funcation02() {
        println("funcation02")
    }
}

/**
 * 接口中实现的方法，可以不必重写
 * 抽象属性需要重写，因为接口不保存状态，所以接口中的属性要么是抽象的，要么是静态实现赋值器的
 * */
class Example01 : Base {

    override var field01: Int = 0

    override val field11: Int = 1

    override fun funcation01() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
