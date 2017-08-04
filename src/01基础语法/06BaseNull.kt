package com.xue.base.`null`

/**
 * 如果一个参数或者返回值，或者变量，可以为空，需要在声明的时候在类型的后面加上？ 表示为空，否则在编译时系统认为是不能为空值得，会导致编译失败
 * 如果声明是没有做可以空的声明，在赋值时做了null的赋值，需要赋值时加!!做声明
 * */

fun parseInt(s: String): Int? {

    try {
        return Integer.parseInt(s)
    } catch (e: NumberFormatException) {
//        e.printStackTrace()
    }

    return null
}

fun parseIntTryNull(s: String?): Int? {

    try {
        return Integer.parseInt(s)
    } catch (e: NumberFormatException) {
//        e.printStackTrace()
    }

    return null
}

fun main(args: Array<String>) {
    println("parseInt 4 == " + parseInt("4"))
    println("parseInt s == " + parseInt("s"))

    var s1: String? = null
    var s2: String = "hh"

    s2 = null!!

    println("parseInt s1 == " + parseInt(s1!!))
    println("parseInt s2 == " + parseInt(s2))

    println("parseInt s1 == " + parseIntTryNull(s1))
    println("parseInt s2 == " + parseIntTryNull(s2))
}