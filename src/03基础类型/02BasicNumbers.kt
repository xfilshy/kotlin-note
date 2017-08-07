package com.xue.basic.numbers

/**
 * kotlin 基本的数字类型,一定要区分java中的类型，是不一样的
 *
 * Byte         8位
 * Short        16位
 * Int          32位
 * Long         64位
 * Float        32位
 * Double       64位
 * */
fun main(args: Array<String>) {
    test03()
}

/**
 * 数字类型的基本声明，整数默认为 Int ，浮点数默认为 Double ，所以Int和Double的声明可以通过系统自动推导 ，其他的需要显示声明
 * 默认为10进制，16进制前面加 0x 2进制前面加 0b
 * 数字后加L代表long型，数字后加F代表浮点型
 * */
fun test01() {
    var byte: Byte = 1

    var short: Short = 1

    var int1: Int = 1
    var int2 = 1

    var long: Long = 1L

    var float: Float = 1.0F

    var double1: Double = 1.0
    var double2 = 1.0

    var intHex16 = 0x1
    var intHex2 = 0b1
}

/**
 * 数字赋值时，可以加下划线分隔 看着数字更清晰
 * 下划线的加入规范完全有自己决定 整数、小数、16进制、2进制都可以加
 * */
fun test02() {
    var int1: Int = 1_0000_0000
    var float1: Float = 1_0000_0000.0000_1f
    var int2: Int = 0xFF_FF_A1
    var int3: Int = 0b1000_1011_011
}

/**
 * 在 Java 平台数字是物理存储为 JVM 的原生类型，除非我们需要一个可空的引用（如 Int?）或泛型。 后者情况下会把数字装箱。
 * 数字装箱不必保留同一性(注意是不必)但保留相等性，就是同一个值自动装箱后并不是同一对象
 * 如果整数取值在byte的 [-128 , 127]范围中，保持同一性，java的享元模式原理
 * */
fun test03() {
    var int = 127

    var unBoxedInt: Int = int
    var boxedInt1: Int? = int
    var boxedInt2: Int? = int

    println("boxedInt1 === boxedInt2 : ${boxedInt1 === boxedInt2}")
    println("boxedInt1 == boxedInt2 : ${boxedInt1 == boxedInt2}")
    println("BoxedInt class == ${boxedInt1?.let { boxedInt1::class }}")
    println("unBoxedInt class == ${unBoxedInt::class}")

    var float = 1f

    var unBoxedFloat: Float = float
    var boxedFloat1: Float? = float
    var boxedFloat2: Float? = float

    println("boxedFloat1 === boxedFloat2 : ${boxedFloat1 === boxedFloat2}")
    println("boxedFloat1 == boxedFloat2 : ${boxedFloat1 == boxedFloat2}")
    println("boxedFloat class == ${boxedFloat1?.let { boxedFloat1::class }}")
    println("unBoxedFloat class == ${unBoxedFloat::class}")

}

/**
 * 显示转换，kotlin中没有提供较小数据类型像较大数据类型的转换语法
 * kotlin任务 较小数据类型与较大数据类型是不存在继承关系的，所以需要显示的转换,这一点的确没有java方便
 * 但是具体理解还是很简答的 java中的int，byte等类型实际是jvm认为的物理原生类型，而kotlin的数字类型实际是普通类，
 * 类似于java中的Integer、Byte，所以这样看的话就舒服多了
 * 在实际使用中其实影响并不巨大，因为在运算过程中，类型是可以由上下文自行推导的
 * */
fun test04() {
    var byte: Byte = 1
    var int: Int = byte.toInt()
    var float: Float = byte.toFloat()


    var byte1: Byte? = 1
    var int1: Int? = byte1?.toInt()
    var float1: Float? = byte1?.toFloat()

    var sum1 = byte + int + float
    var sum2 = byte1!! + int1!! + float1!!
}

/**
 * Kotlin支持数字运算的标准集，运算被定义为相应的类成员（但编译器会将函数调用优化为相应的指令）。
 * 对于位运算，没有特殊字符来表示，而只可用中缀方式调用命名函数
 * 这是完整的位运算列表（只用于 Int 和 Long）：
 *
 * shl(bits) – 有符号左移 (Java 的 <<)
 * shr(bits) – 有符号右移 (Java 的 >>)
 * ushr(bits) – 无符号右移 (Java 的 >>>)
 * and(bits) – 位与
 * or(bits) – 位或
 * xor(bits) – 位异或
 * inv() – 位非
 *
 * 不做说明了
 * */
fun test05() {
    1 shl 2
}