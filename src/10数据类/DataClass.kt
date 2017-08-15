package com.xue.dataclass

/**
 * Pair 和 Triple 是系统提供的简单的数据存储结构  比较适合标准结构
 * */
fun main(args: Array<String>) {
    var p = Person("xue", 20)
    var op = p.copy(age = 40)


    /**
     * 解构声明 略屌  来我试试 循环语句
     * */
    val jane = Person("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age")

    var list = listOf(Person("1", 1), Person("2", 2))

    /**
     * 这波装逼满分吧
     * */
    for ((name1, age2) in list) {
        println("name $name1 age $age2")
    }
}

/**
 *
 * 1.主构造函数必须有参数
 * 2.主构造函数参数必须是以属性的声明形式
 * 3.数据类不能是抽象、开放、密封或者内部的
 * 4.数据类如果需要无参构造函数，只能通过给默认值得形式实现
 * 5.编译器自动推导成员 equals()/hashCode()/toString()/copy()/componentN()
 * */
data class Person(var name: String, var age: Int) {

    /**
     * 系统生成的copy方法就是这样的 调用很爽吧
     * */
    fun copy1(name: String = this.name, age: Int = this.age) = Person(name, age)

}
