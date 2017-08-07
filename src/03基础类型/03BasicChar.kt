package com.xue.basic.char

fun main(args: Array<String>) {
    test01()
    test02()
}

/**
 * Char不能直接当做数字，但是可以通过显示转换转换层数字
 * */
fun test01() {
    var char: Char = '薛'
    println("char $char to int ${char.toInt()}")


}

/**
 * 对非空引用自动装箱 不必保持同一性 保持相等性
 * 且也满足数字的享元模式
 *
 * 简单的说就是和数字完全一样
 * */
fun test02() {
    var char: Char = '薛'
    var boxedChar1: Char? = char
    var boxedChar2: Char? = char

    println("boxedChar1 === boxedChar2 : ${boxedChar1 === boxedChar2}")
    println("boxedChar1 == boxedChar2 : ${boxedChar1 == boxedChar2}")

    var int = 1
    var char1: Char = int.toChar()
    var boxedChar3: Char? = char1
    var boxedChar4: Char? = char1

    println("boxedChar3 === boxedChar4 : ${boxedChar3 === boxedChar4}")
    println("boxedChar3 == boxedChar4 : ${boxedChar3 == boxedChar4}")
}