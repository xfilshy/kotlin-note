package com.xue.`this`

fun main(args: Array<String>) {

    /**
     * 内部类 看声明就知道  C内部可以有B的引用
     * */
    var c = B().C()

    /**
     * 嵌套类 D只是结构上属于B 有点类似包
     * */
    var d = B.D()

    /**
     * 伴生对象 看起来像一个静态的 单例的对象 他属于类 不单属于任何一个对象
     * */
    var e = B.E
}

/**
 * 为了表示当前的 接收者 我们使用 this 表达式：
 *
 * 在类的成员中，this 指的是该类的当前对象
 * 在扩展函数或者带接收者的函数字面值中， this 表示在点左侧传递的 接收者 参数。
 * 如果 this 没有限定符，它指的是最内层的包含它的作用域。要引用其他作用域中的 this，请使用 标签限定符
 * */
class AA {

    fun test() {
        println(this)
    }
}

fun Int.print() {
    println(this)
}


class B {

    val x = "123"

    inner class C {

        val x = "321"

        fun test() {
            println("C test ${this.x}")
            println("C test ${this@B.x}")//很好理解吧
            println("C test ${E.x}")//伴生对象 看着是不是非常想java里的静态变量
        }
    }

    class D {
        fun test() {
            println("D test")
        }
    }

    companion object E {

        val x = "111"

        fun test() {
            println("E test")
        }
    }

    fun test() {
        println("B test $x")
    }
}

/**
 * 比较全了 小细节很多 需要格外的注意
 * */
class A { // 隐式标签 @A
    inner class B { // 隐式标签 @B
        fun Int.foo() { // 隐式标签 @foo
            val a = this@A // A 的 this
            val b = this@B // B 的 this

            val c = this // foo() 的接收者，一个 Int
            val c1 = this@foo // foo() 的接收者，一个 Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit 的接收者
                val e = this@lambda // funLit 的接收者
            }


            val funLit2 = { s: String ->
                // foo() 的接收者，因为它包含的 lambda 表达式
                // 没有任何接收者
                val d1 = this
            }
        }
    }
}
