package com.xue.modifiers

/**
 * 类、对象、接口、构造函数、方法、属性和它们的 setter 都可以有 可见性修饰符。
 * （getter 总是与属性有着相同的可见性。） 在 Kotlin 中有这四个可见性修饰符：
 * private、 protected、 internal 和 public。
 * 如果没有显式指定修饰符的话，默认可见性是 public。
 * */
fun main(args: Array<String>) {

}

/**
 * 以下为顶层声明 （因为kotlin代码不需要一个文件对应一个class 允许存在在class外的顶层代码）
 *
 * public 所以地方可见
 * internal 模块内可见
 * private 内部可见
 * protected 他不能修饰顶层声明，因为他针对 子类可见
 *
 *
 * 模块
 * 可见性修饰符 internal 意味着该成员只在相同模块内可见。更具体地说， 一个模块是编译在一起的一套 Kotlin 文件：
 *
 * 一个 IntelliJ IDEA 模块；
 * 一个 Maven 项目；
 * 一个 Gradle 源集；
 * 一次 ＜kotlinc＞ Ant 任务执行所编译的一套文件。
 *
 * */
public var publicValue = 1

internal var internalValue = 1

private var privateValue = 1

public fun publicFun() = 1

internal fun internalFun() = 1

private fun privateFun() = 1

public class PublicClass

internal class InternalClass

private class privateClass

/**
 * 对于类内部声明的成员
 *
 * private 意味着只在这个类内部（包含其所有成员）可见；
 * protected—— 和 private一样 + 在子类中可见。
 * internal —— 能见到类声明的 本模块内 的任何客户端都可见其 internal 成员；
 * public —— 能见到类声明的任何客户端都可见其 public 成员。
 * */
open class Sample {

    public var classPublicValue = 1

    internal var classInternalValue = 1

    protected var classProtected = 1

    private var classPrivateValue = 1

    open public fun classPublicFun() = 1

    open internal fun classInternalFun() = 1

    open protected fun classProtectedFun() = 1

    /**
     * private的成员无法open ， 因为都访问不到
     * */
    private fun classPrivateFun() = 1

}

class SampleSon : Sample() {

    fun test() {
        classProtected
        classProtectedFun()
    }

    /**
     * 子类重写的可见性 一定是高级 超类的，因为你先要满足父类的访问调用需求 public > internal > protected > private
     * */
    public override fun classProtectedFun(): Int {
        return super.classProtectedFun()
    }
}

/**
 * 构造函数的可见性声明其实没什么好说的 因为和类内方法一样
 * 局部变量是没有可见性的概念的
 * */
