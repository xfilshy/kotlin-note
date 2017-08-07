package com.xue.base.range

fun main(args: Array<String>) {
    println("全闭区间 1 .. 10 包含 1 和 10 如 ： 10 in 1 .. 10 = ${10 in 1..10}")
    println("半开区间 1 until 10 包含 1 不包含 10 如 ： 10 in 1 .. 10 = ${10 in 1 until 10}")
    println("全闭区间 10 downTo 1 包含 10 和 1 如 ： 1 in 10 downTo 1 = ${1 in 10 downTo 1}")
}