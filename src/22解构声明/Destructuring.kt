package com.xue.destructuring


fun main(args: Array<String>) {


}

data class Person(var name: String, var age: Int)

class Student(var name: String, var age: Int, var teacher: Person)

/**
 * 将对象person解构成 name ，age
 *
 * 普通类不提供componentN()方法 所以无法解构  数据类默认更具主构造函数提供了componentN()方法 所以可以顺利解构
 *
 * 普通类 可以 自己实现 componentN方法 component1、componentN2... 就是解构的顺序
 *
 * 任何表达式都可以出现在解构声明的右侧，只要可以对它调用所需数量的 component 函数即可
 * */
fun test1() {
    var person = Person("xue", 30)
    val (name, age) = person

    println("person : $person")
    println("name : $name")
    println("age : $age")

    var student = Student("aa", 20, person)
//    val (sname, sage, teacher) = student  为啥不能解构呢
}

/**
 * for循环解构  实际是  Array的结构
 * */
fun test2() {
    var array = arrayOf(Person("1", 20), Person("2", 20))

    for ((name, age) in array) {

    }
}

data class Result(val result: Int, val status: String)

fun function(): Result {
    return Result(12, "123")
}

/**
 * 这个好像没什么说的 实际计算对象结构
 * */
fun test3() {
    val (result, status) = function()
}

/**
 * map的解构
 * */
fun test4() {
    var map = mapOf(1 to 2, 2 to 3)
    for ((key, value) in map) {
        // 使用该 key、value 做些事情
    }
}

fun getResult(): Pair<Int, Int> {
    return Pair(1, 2)
}


/**
 * 不使用的解构元素 可以用_下划线声明
 * */
fun test5() {
    val (_, status) = getResult()

    println("status = $status")
}

fun getPerson(f: (Person) -> Unit) {
    f(Person("xue", 20))
}

/**
 * 简单的lambda表达式的参数部分的解构
 *
 * 注意细节：
 * { a //-> …… } // 一个参数
 * { a, b //-> …… } // 两个参数
 * { (a, b) //-> …… } // 一个解构对
 * { (a, b), c //-> …… } // 一个解构对以及其他参数
 * */
fun test6() {
    getPerson { person -> println("person = $person") }
    getPerson { (name, age) -> println("name = $name age = $age") }
}

/**
 * 注意一下写法就行了
 * */
fun test7() {
    var map = mapOf(1 to 2, 2 to 3)
    map.mapValues { (_, value): Map.Entry<Int, Int> -> "$value!" }
    map.mapValues { (_, value) -> "$value!" }
    map.mapValues { (_: Int, value: Int) -> "$value!" }
}

