package com.xue.basic.string

fun main(args: Array<String>) {
    test02()
}

/**
 * String可以通过循环语句配合in遍历每个字符
 * */
fun test01() {
    var name = "xueliyu"

    for (s in name) println(s)
}

/**
 * kotlin有两种类型字符串 转译字符串 和 原生字符串（原生字符串内不能有任何转义，但是可以含有任何字符）
 *
 * 原生字符串书写会保留你做出的任何换行和空格，这样你在格式化代码的痕迹都会被记录出来，所以trimMargin()方法用来去除前置空格，而默认|作为边界前缀，可以自行指定
 * */
fun test02() {

    var simpleString = "xueliyu\n"

    val bigString =
            """|xueliyu
            |hahah
            |asda
            |kkkaadads""".trimMargin()

    println(simpleString)
    println(bigString)
}

/**
 * 字符串模板插入就不在赘述，主要是在原生字符串时 $符号的输入方式
 * */
fun test03() {
    var value = 123

    println("value == $value")
    println("value + 10 == ${value + 10}")
    println("""i hava ${'$'}$value""")
}
