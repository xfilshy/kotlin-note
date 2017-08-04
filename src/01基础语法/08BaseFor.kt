package com.xue.base.`for`

/**
 * for循环语句的基本语法 直接遍历 或者 遍历 index
 *
 * listOf构建混合类型的数组很好玩吧 其实只是泛型为 Any
 * */
fun main(args: Array<String>) {
    var list = listOf(1, 2, 3, 4)

    for (ele in list)
        println("ele == " + ele)

    for (index in list.indices)
        println("index ele == " + list[index])

    var testList = listOf(1, "23", 2.3, Object())

    for (ele in testList)
        println("ele type == ${ele::class} value == $ele")
}