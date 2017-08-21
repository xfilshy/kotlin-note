package com.xue.generics

fun main(args: Array<String>) {
    /**
     * 最完整的写法
     * */
    var box1: Box<Int> = Box<Int>(1)

    /**
     * 类型自动推断类型
     * */
    var box2 = Box(2)


    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    copy2(ints, any)

    var ss1: Array<String> = Array<String>(10) { "" }
    var ss2: Array<Any> = Array<Any>(10) { "" }

    fill1(ss1, "")
    fill1(ss2, "")

    var ay1: Array<*> = arrayOf(1, 2, 3)
}

/**
 * 最普通的泛型
 * */
class Box<out T>(t: T) {
    val t: T = t
}

/**
 * out代表生产者
 * */
interface A<out T> {
    fun getValue(): T
}

/**
 * val声明的属性 这样也构成了生产者
 * */
class A1<out T>(t: T) {
    val t: T = t
}


/**
 * in代表消费者
 * */
interface B<in T> {
    fun setValue(t: T)
}

/**
 * 这个样子就变成了常规泛型
 * */
interface C<T> {

    fun getValue(): T

    fun setValue(t: T)
}

/**
 * 这样的写法 调用时 传入对象一定都是 Array<Any>
 * */
fun copy1(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

/**
 * 这样写的话 调用时 form传入就可以是 任意Any的子类
 * 这里的from数组是受限制 只能读取不能写入
 * */
fun copy2(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

/**
 * 函数dest只能是Array<String> 才能写入成功
 * */
fun fill1(dest: Array<String>, value: String) {
    dest[0] = value
}

/**
 * 函数dest只有是 String超类数组 都能被写入 , 还注意一下  上下两个函数 编辑器居然区分成了两个函数 我震惊了
 * */
fun fill1(dest: Array<in String>, value: String) {
    dest[0] = value
}

/**
 * 星投影  不太理解  回头代码慢慢体会
 * */


/**
 * 泛型函数
 * */
fun <T> get(item: T): List<T> {
    return listOf(item)
}

/**
 * 泛型约束， 意义代表  T参数必须是实现了Comparable接口
 * */
fun <T : Comparable<T>> sort1(list: List<T>) {

}


/**
 * 多重泛型约束 ， where关键字  这里代表 T要实现 Comparable接口和Cloneable接口
 * */
fun <T> sort2(list: List<T>) where T : Comparable<T>, T : Cloneable {

}