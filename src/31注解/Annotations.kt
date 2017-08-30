package com.xue.annotations

import kotlin.reflect.KClass

fun main(args: Array<String>) {
    println("f = $f")
}

/**
 *注解的附加属性可以通过用元注解标注注解类来指定：
 *
 * @Target 指定可以用该注解标注的元素的可能的类型（类、函数、属性、表达式等）；
 * @Retention 指定该注解是否存储在编译后的 class 文件中，以及它在运行时能否通过反射可见 （默认都是 true）；
 * @Repeatable 允许在单个元素上多次使用相同的该注解；
 * @MustBeDocumented 指定该注解是公有 API 的一部分，并且应该包含在生成的 API 文档中显示的类或方法的签名中。
 * */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
@MustBeDocumented
annotation class Fancy


@Fancy
class Foo {
    @Fancy
    fun baz(@Fancy foo: Int): Int {
        var dd = Foo::class
        return (@Fancy 1)
    }
}

/**
 * 如果需要对类的主构造函数进行标注，则需要在构造函数声明中添加 constructor 关键字 ，并将注解添加到其前面
 * 你也可以标注属性访问器
 * */
class Foo1 @Fancy constructor() {

    var x: String? = null
        @Fancy set
}

enum class EE {
    Fuck
}

/**
 * 注解也可以接受参数
 *
 * 允许的参数类型有 ：
 *
 * 对应于 Java 原生类型的类型（Int、 Long等）；
 * 字符串；
 * 类（Foo::class）；
 * 枚举；
 * 其他注解；
 * 上面已列类型的数组。
 *
 * 注解参数不能有可空类型，因为 JVM 不支持将 null 作为注解属性的值存储。
 * 如果需要将一个类指定为注解的参数，请使用 Kotlin 类 （KClass）。
 * Kotlin 编译器会自动将其转换为 Java 类，以便 Java 代码能够正常看到该注解和参数
 * */
annotation class Special(
        val int: Int,
        val string: String,
        val foo: KClass<Foo>,
        val fancy: KClass<Fancy>,
        val ee: EE)


/**
 * 注解也可以用于 lambda 表达式。它们会被应用于生成 lambda 表达式体的 invoke() 方法上。
 * 这对于像 Quasar 这样的框架很有用， 该框架使用注解进行并发控制。
 * */
annotation class Suspendable

val f = @Suspendable { println(123123) }

annotation class Ann

/**
 * 注解暂时这样 详细的情况再研究
 * */
