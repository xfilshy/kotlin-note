package com.xue.nestedclass

/**
 * 嵌套类是一个独立的类，类似于java的静态类
 * 内部类是依托于外部类对象的，可以见外部类的成员
 *
 * 匿名内部类声明用object关键字
 * 如果对象是函数式 Java 接口（即具有单个抽象方法的 Java 接口）的实例， 你可以使用带接口类型前缀的lambda表达式创建它
 * */
fun main(args: Array<String>) {
    val demo1: Outer.Nested = Outer.Nested() // == 2
    val demo2: Outer.Inner = Outer().Inner()

    var view = View()

    view.setOnClickListener(object : OnClickListenr {
        //匿名内部类就这样声明了 object关键字
        override fun onClick(v: View) {

        }
    })
}

/**
 * 这里Nested就是一个嵌套类
 * 说白了就是类里声明一个类，就叫嵌套类
 * */
class Outer {
    private val bar: Int = 1

    /**
     * 嵌套类
     * */
    class Nested {
        fun foo() = 2
    }


    /**
     * 类可以标记为 inner 以便能够访问外部类的成员。
     * 内部类会带有一个对外部类的对象的引用
     * */
    inner class Inner {

        var bar: String = ""

        fun foo() = this@Outer.bar
    }
}

class View {

    fun setOnClickListener(listener: OnClickListenr) {

    }
}

interface OnClickListenr {

    fun onClick(v: View)
}