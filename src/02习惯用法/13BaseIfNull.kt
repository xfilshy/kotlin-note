package com.xue.base.`if`.`null`

import com.xue.base.map.test


/**
 * 这里涉及到了两种写法
 *
 * ?. 意义是 如果被调用方法或属性的对象为空不报错 实际就是这样的一个方法
 *      fun fx(对象 , 函数或方法) : T{
 *          if(对象 == null) return null
 *
 *          return 对象.函数或方法
 *      }
 *
 * ?: 这个意义是 ?号前的对象如果为空 执行:后的函数式
 *      fun fx(对象 , 函数式) : T{
 *          if(对象 == null)
 *              return 函数或方法
 *      }
 *
 * ?.let 和 ?.很像 只是执行的是函数块
 *
 *
 * 比较容易的记忆方法， ?. 不为null执行  ?: 为null执行
 *
 * 另外看到关于返回值得思考 默认返回值时 最好一行代码的值就是返回值,仔细品味一下
 * */
fun main(args: Array<String>) {
    var list: List<Int>? = listOf()
    var size = list?.size
    println("size = " + test(list))

//    list = listOf()
//    size = list?.size
//    println("size = $size")

//    println(list?.size ?: println("else println"))

//    println(list ?: println("list is null"))

//    println(list?.let {
//        println("3123")
//        println(312312)
//        1 + 2
//
//        return Unit
//    })
}

fun test(list: List<*>?): Int {
    println(list?.let {
        return it.size
    })

    return 0
}



