package com.xue.base.default.parameter

/**
 * 默认参数 又是一个很好玩的语法糖
 *
 * defaultParams01 defaultParams02 defaultParams03 defaultParams04
 *
 * 有默认参数的情况下调用时可以不用传入，但是默认值参数的位置会影响一些调用的细节，在调用时，填入的参数没有明确的指向的情况下是按函数的参数顺序进行赋值的
 * 编译器是不会智能到能理解你需要跳过默认参数对其他参数赋值，所以如果想很顺畅的使用默认参数，可以将默认参数申明在参数的后面 如defaultParams04，当然也可
 * 如 defaultParams02 和 defaultParams03 这样的调用 明确赋值给指定参数 让我又想起了 python
 * */
fun main(args: Array<String>) {
    defaultParams01()
    defaultParams02(height = 180)
    defaultParams03(age = 180)
    defaultParams04("xue")
}

fun defaultParams01(name: String = "xue", age: Int = 20) {

}

fun defaultParams02(name: String = "xue", age: Int = 20, height: Int) {

}

fun defaultParams03(name: String = "xue", age: Int, height: Int = 170) {

}

fun defaultParams04(name: String, age: Int = 20, height: Int = 170) {

}
