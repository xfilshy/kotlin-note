package com.xue.jump.`continue`
/**
 * continue的用法也很常规
 * 带标签的continue也是在多层循环的时候使用，使用也是continue到标签循环语句的当次循环句末
 * */
fun main(args: Array<String>) {
    test02()
}

fun test01() {

    for (i in 1..10) {
        if (i == 4) continue

        println("i == $i")
    }
}

fun test02() {

    for (i in 1..10) {
        flag@ for (j in 1..10) {
            if (i == 4) continue@flag

            println("i = $i  j = $j")
        }
    }
}