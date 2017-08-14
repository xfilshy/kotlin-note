/**
 * 目录和包名无需匹配，源代码可以在文件系统的任意位置。
 * 包名中如果含有敏感字段，如 中文、系统关键字等，需要单独用``（不是单引号）引起来，如下
 */
package com.xue.define.`package`

import com.xue.modifiers.*


/**
 * 测试一下08可见性修饰符
 * */
fun main(args: Array<String>) {
    publicValue
    publicFun()
    var v = PublicClass()

    internalValue
    internalFun()
    var vv = InternalClass()
}