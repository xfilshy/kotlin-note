package com.xue.jump.`return`

/**
 * return。默认从最直接包围它的函数或者匿名函数返回。
 *
 * test03 和 test04 是完全一样的
 * */
fun main(args: Array<String>) {
//    println(test01(Person(null, 20)))
//
//    test02()
//    test03()
//    test04()
    test05()
}

fun test01(person: Person) {
    val s = person.name ?: return
    println("s == $s")
    println("person name: ${person.name} age: ${person.age}")
}

data class Person(var name: String?, var age: Int?)

/**
 * forEach中的return 是整个函数的返回
 * */
fun test02() {
    var array = arrayOf(1, 2, 3, 4)

    array.forEach {
        if (it == 3) return

        println("it = $it")
    }

    println("pppppp")
}

/**
 * forEach中带标签的return 只返回当前的方法块
 *
 * 这个 return 表达式从最直接包围它的函数即 test03 中返回。 （
 * 注意，这种非局部的返回只支持传给内联函数的 lambda 表达式。）
 * 如果我们需要从 lambda 表达式中返回，我们必须给它加标签并用以限制 return。
 * */
fun test03() {
    println("test03")

    var array = arrayOf(1, 2, 3, 4)

    array.forEach lit@ {
        if (it == 3) return@lit

        println("it = $it")
    }

    println("pppppp")
}

/**
 * 现在，它只会从 lambda 表达式中返回。
 * 通常情况下使用隐式标签更方便。
 * 该标签与接受该 lambda 的函数同名。
 * */
fun test04() {
    println("test04")

    var array = arrayOf(1, 2, 3, 4)

    array.forEach {
        if (it == 3) return@forEach

        println("it = $it")
    }

    println("pppppp")
}

/**
 * 函数内的return是返回当前函数
 * 这种形式怎么跳出forEach呢，
 * */
fun test05() {
    println("test05")

    var array = arrayOf(1, 2, 3, 4, 5)

    array.forEach(fun(value: Int) {
        if (value == 3) return

        println("value == $value")
    })

    println("pppppp")
}
