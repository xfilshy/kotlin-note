package com.xue.base.DTOs

/**
 * 数据类初步了解
 * 基本写法 data class 类名(参数声明){类块可以省略}
 * 数据类 默认帮实现了 toString equals copy hashCode
 * 所有属性的 getters和setters（var可变变量的声明方式才能有setters，可以看看Person类的name 和 age的声明差别）
 * 所有属性的 component1()、 component2()……等等
 *
 * 是不是很爽 以后写个业务bean也许一行就够了，而且他可以以极简的形式实现，也可以如正常类那也写方法
 * */
fun main(args: Array<String>) {

    var p1 = Person("A", 20)
    var p2 = Person("A", 20)

    println("p1 = $p1")
    println("p2 = $p2")
    println("p1 copy = ${p1.copy()}")
    println("p1 == p2 : ${p1 == p2}")
    println("p1.equals(p2) : ${p1.equals(p2)}")
    p1.test()
}

data class Person(var name: String, val age: Int) {
    fun test() {
        println("试试方法可以用吗")
    }
}
