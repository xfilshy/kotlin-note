package com.xue.base.`is`

/**
 * is判断成立后 自动内转换，在is作用范围内有效
 * */
fun getStringLengt01(value: Any): Int {
    if (value is String) {
        return value.length
    }

    return null!!
}

fun getStringLength02(value: Any): Int {
    if (value !is String) return null!!
    return value.length
}

fun getStringLength03(value: Any): Int {
    if (value is String && value.length > 0) {
        return value.length
    }
    return null!!
}