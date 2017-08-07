package com.xue.base.`if`

/**
 * 有是一个默认返回 条件语句是做返回时 注意一定是满足所有条件都有默认值
 *
 * test01 和 test02 是一样的
 * */
fun main(args: Array<String>) {
    test01(1)
    test02(2)
}

fun test01(param: Int): String {
    return if (param == 1) {
        "red"
    } else if (param == 2) {
        "blue"
    } else {
        "green"
    }
}

fun test02(param: Int): String {
    return if (param == 1) {
        return "red"
    } else if (param == 2) {
        return "blue"
    } else {
        return "green"
    }
}