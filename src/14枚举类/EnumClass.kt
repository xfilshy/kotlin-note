package com.xue.enumclass

/**
 * 每个枚举常量都具有在枚举类声明中获取其名称和位置的属性
 * name 名字 ， ordinal 位置
 * */
fun main(args: Array<String>) {
    var v1 = Direction.NORTH
    var v2 = Color.valueOf("RED")
    var v3 = Color.values()

    println("v1 = $v1")
    println("v2 = $v2")
    println("v3 = $v3")

    printAllValues<Color>()


}

/**
 * 常规枚举，看着和Java毫无区别
 * */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

/**
 * 带主构造函数，初始化的枚举
 * */
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * 可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量
 * */
inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}


/**
 * 匿名类，妈的匿名在哪里了 这个不就是一个抽象方法么
 * */
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}