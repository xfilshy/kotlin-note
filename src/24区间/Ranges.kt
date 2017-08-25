package com.xue.ranges

fun main(args: Array<String>) {
    test7()

    test10()
}

/**
 * 区间的一个简单写法
 * 1 .. 10 代表  [1 , 10] 的闭合 整数区间（IntRange） 也就是（1，2，3，4，5，6，7，8，9，10）
 *
 * 看看IntRange中的匿名伴生对象中的   public val EMPTY: IntRange = IntRange(1, 0)  声明  区间的 大小反了就是可一个空区间
 *
 * r1 和 r2 是一样的
 * */
fun test1(value: Int) {
    var r1 = IntRange(1, 10)
    var r2 = 1..10

    if (value in 1..10) println("value:$value in 1 .. 10")

}

/**
 * 因为实现了迭代器 所以 循环语句也可
 * */
fun test2() {
    for (x in 1..10) {
        println("x = $x")
    }
}

/**
 * downTo 倒序区间
 * */
fun test3() {
    for (i in 4 downTo 1) print(i) // 输出“4321”
}

/**
 * 再加个步长  舒服不
 * */
fun test4() {
    for (i in 1..4 step 2) print(i)
}

/**
 * until 左闭右开
 * */
fun test5() {
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        println(i)
    }
}

/**
 * 整数数列 是 IntRange 的父类
 * */
fun test6() {
    var v = IntProgression.fromClosedRange(1, 10, 1)

    for (i in v) {
        println("i = $i")
    }
}

/**
 * rangeTo() 函数
 *
 * 例子生成了一个 1 .. 10
 * */
fun test7() {
    var r = 1.rangeTo(10)

    r.forEach { println("it == $it") }

    /**
     * 这个是扩展函数 生成的一个 闭区间  但是不能迭代  因为没有实现迭代器
     * */
    var r1 = 1.2.rangeTo(2.0)
}

/**
 * downTo 函数
 *
 * 和rangeTo的用法一样  浮点数没有downTo函数
 * */
fun test8() {
    var r = 10.downTo(1)

    r.forEach { println("it == $it") }
}

/**
 * public operator fun <T: Comparable<T>> T.rangeTo(that: T): ClosedRange<T> = ComparableRange(this, that)
 *
 * 这个方法  可以看出 只要实现了Comparable接口  就可以调用rangeTo  生成一个  ComparableRange
 * */


/**
 * reversed() 函数
 *
 * 翻转数列 *Progression  主要是数列  doubleRange 不是数列的  数列的特点是又穷可枚举的
 * */
fun test9() {
    var intP = (1..10).reversed()
}


/**
 * step() 函数
 * 改变原有数列的步长 生成新的数量
 *
 * 主要的是  step()函数step不能为负数 因为step只改变步长 并使数列反向
 * */
fun test10() {

    var r1 = 1..10

    var r2 = 10 downTo 1

    var intP1 = r1.step(2)

    var intP2 = r2.step(2)

    var intP3 = r2.step(-2)

    println("intP1 == $intP1")
    println("intP2 == $intP2")

}

/**
 * IntRange 和 LongRange 实际上就是 步长为 1 的  IntProgression 和 LongProgression
 * */

