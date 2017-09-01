/**
 * package指定包名
 * */
package com.xue.keywordsandoperators


/**
 * as 为导入指定一个别名
 * */
import java.io.Serializable
import javax.swing.tree.TreeNode
import kotlin.concurrent.thread
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import java.lang.Runnable as RUN

fun main(args: Array<String>) {
    test19(null)

    k.text()
    C.X.test()
    D.test()
}

/**
 * 硬关键字
 *
 * 以下符号会始终解释为关键字，不能用作标识符
 *
 * as  用于类型转换
 *     为导入指定一个别名
 *
 * as? 用于安全类型转换
 *
 * break 终止循环的执行
 *
 * class 声明一个类
 *
 * continue 继续最近层循环的下一步
 *
 * do 开始一个 do/while 循环（后置条件的循环）
 *
 * else 定义一个 if 表达式条件为 false 时执行的分支
 *      为when语句的default情况
 *
 * false 指定布尔类型的“假”值
 *
 * for 开始一个 for 循环
 *
 * fun 声明一个函数
 *
 * if 开始一个 if 表达式
 *
 * in  指定在 for 循环中迭代的对象
 *     用作中缀操作符以检查一个值属于一个区间、 一个集合或者其他定义“contains”方法的实体
 *     在 when 表达式中用于上述目的
 *     将一个类型参数标记为逆变
 *
 * !in 用作中缀操作符以检查一个值不属于一个区间、 一个集合或者其他定义“contains”方法的实体
 *     在 when 表达式中用于上述目的
 *
 * interface 声明一个接口
 *
 * is  检查一个值具有指定类型     空安全的
 *     在 when 表达式中用于上述目的
 *
 * !is 检查一个值不具有指定类型
 *     在 when 表达式中用于上述目的
 *
 * null 是表示不指向任何对象的对象引用的常量
 *
 * object 同时声明一个类及其实例
 *
 * package 指定当前文件的包
 *
 * return 从最近层的函数或匿名函数返回
 *
 * super  引用一个方法或属性的超类实现
 *        在次构造函数中调用超类构造函数
 *
 * this  引用当前接收者
 *       在次构造函数中调用同一个类的另一个构造函数
 *
 * throw 抛出一个异常
 *
 * true 指定布尔类型的“真”值
 *
 * try 开始一个异常处理块
 *
 * typealias 声明一个类型别名
 *
 * val 声明一个只读属性或局部变量
 *
 * var 声明一个可变属性或局部变量
 *
 * when 开始一个 when 表达式（执行其中一个给定分支）
 *
 * while 开始一个 while 循环（前置条件的循环）
 * */

/**
 * as 类型转换
 * */
fun test1() {
    var x: Any = "123"

    var s: String = x as String
}

/**
 * as? 安全的类型转换
 * */
fun test2() {
    var x: Any? = null

    var s: String? = x as? String
}

/**
 * break跳转循环
 * */
fun test3() {
    for (i in 1..10) {
        if (i == 5) {
            break
        }
    }
}

/**
 * class 类声明
 * */
class A

/**
 * continue跳出单次循环
 * */
fun test4() {
    for (i in 1..10) {
        if (i == 5) {
            continue
        }
    }
}

/**
 * do 开始一个 do/while循环
 * */
fun test5() {
    var i = 0
    do {
        i++
    } while (i < 0)
}

/**
 * else 为if语句的否定分支
 * */
fun test6() {
    var i = 2
    if (i == 1) {

    } else {

    }
}

/**
 * else 为when语句的default情况
 * */
fun test7(i: Int) {
    when (i) {
        1 -> println(1)
        2 -> println(2)
        else -> println("else")
    }
}

/**
 * 否定布尔值
 * */
fun test8() {
    var f = false
}

/**
 * for for循环语句
 * */
fun test9() {
    for (i in arrayOf(1, 2, 3)) {

    }
}

/**
 * fun 声明函数的关键字
 * */
fun test10() {

}

/**
 * if 声明if语句或者if表达式
 * */
fun test11() {
    var i = 1
    if (i == 2) {

    }

    var j = if (i == 1) 3 else 2
}

/**
 * in 判断是否属于集合
 * */
fun test12() {
    var b = 1 in 1..10
}

/**
 * in for循环中遍历集合
 * */
fun test13() {
    for (i in 1..10) {

    }
}

/**
 * in when语句中做包含判断
 * */
fun test14(value: Int) {
    when (value) {
        in 1..4 -> println("in")
    }
}

/**
 * in 泛型中做逆变操作
 * */
fun test15(list: ArrayList<in Int>) {
    var c = list[0]
}

/**
 * 做不包含判断
 * */
fun test16() {
    var b = 1 !in 1..10
}

/**
 * !in when语句中做不包含判断
 * */
fun test17(value: Int) {
    when (value) {
        in 1..4 -> println("in")
    }
}

/**
 * interface 声明一个接口
 * */
interface B

/**
 * is 做类型是判断
 * */
fun test18(value: Any) {
    var b = value is String
}

/**
 * !is 做类型非判断
 * */
fun test19(value: Any?) {
    var b = value !is String

    println("b == $b")
}

/**
 * null 声明空
 * */
var v = null


/**
 * object 声明类同时声明对象
 *
 * object 声明单例
 * */
private var k = object : Comparable<Int> {

    override fun compareTo(other: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun text() {}
}

class C {
    object X {
        fun test() {

        }
    }
}

class D {
    companion object X {
        fun test() {

        }
    }
}

fun test20() {
    return Unit
}


/**
 * super 引用超类构造函数的实现
 * this 引用自身构造函数实现
 *
 * super 引用超类成员实现
 * this 引用自身成员
 * */
open class AA() {

    open fun test() {

    }
}

class BB : AA {

    constructor(v: Int) : super()

    constructor(v: Int, s: String) : this(v)

    override fun test() {
        super.test()
        this.toString()
    }
}

/**
 * throw 抛出一个异常
 * */
fun test21() {
    throw Exception()
}

/**
 * true 布尔真
 * */
var bb = true

/**
 * try 声明异常处理语句
 *  */
fun test22() {
    try {

    } catch (e: Exception) {

    } finally {

    }
}

/**
 * 声明类型别名
 * */
typealias StringList = ArrayList<String>
typealias Fun1 = (Int) -> Int

/**
 * val 声明不可变变量
 * */
val a = 1

/**
 * var 声明可变变量
 * */
var b = 2


/**
 * when 声明when条件语句
 * */
fun test24(value: Int) {
    when (value) {

    }
}

/**
 * while 声明while循环语句
 * */
fun test25() {
    while (true) {

    }
}

/**
 * 软关键字
 *
 * 以下符号在适用的上下文中充当关键字，而在其他上下文中可用作标识符：
 *
 * by  将接口的实现委托给另一个对象
 *     将属性访问器的实现委托给另一个对象
 *
 * catch 开始一个处理指定异常类型的块
 *
 * constructor 声明一个主构造函数或次构造函数
 *
 * delegate 用作注解使用处目标
 *
 * dynamic 引用一个 Kotlin/JS 代码中的动态类型
 *
 * field 用作注解使用处目标
 *
 * file 用作注解使用处目标
 *
 * finally 开始一个当 try 块退出时总会执行的块
 *
 * get  声明属性的 getter
 *      用作注解使用处目标
 *
 * import 将另一个包中的声明导入当前文件
 *
 * init 开始一个初始化块
 *
 * param 用作注解使用处目标
 *
 * property 用作注解使用处目标
 *
 * receiver用作注解使用处目标
 *
 * set  声明属性的 setter
 *      用作注解使用处目标
 *
 * setparam 用作注解使用处目标
 *
 * where 指定泛型类型参数的约束
 * */

/**
 * 将接口实现委托给 对象 注意是对象
 * */
interface IA {
    fun test(): String
}

object OA : IA {
    override fun test(): String {
        return "123"
    }
}

class CAA : IA {
    override fun test(): String {
        return "asss"
    }
}


/**
 * by 以下都是属性委托的一般形式
 *
 * 这里还有涉及到的延迟初始化  监听变化   映射等委托就不举例了
 * */
class CA1 : IA by OA

class CA2 : IA by CAA()

var Va1: String by DA1()

class DA1 : ReadWriteProperty<Nothing?, String> {

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

var Va2: String by DA2()

class DA2 {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, s: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

var Va3: String by object {

    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, s: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

var Va4: String by object : ReadWriteProperty<Nothing?, String> {

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

var Va5: String by Fa()

fun Fa(): ReadWriteProperty<Nothing?, String> {
    return object : ReadWriteProperty<Nothing?, String> {

        override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}

/**
 * catch 捕获异常
 * */
fun test23() {
    try {

    } catch (e: Exception) {

    }
}

/**
 * 声明主 副构造函数
 * */
class E constructor() {

    constructor(name: String) : this()
}

/**
 * delegate 这个没找到怎么用 和 委托属性的注解有关
 * */

/**
 * dynamic 动态属性
 * */


/**
 * finally 异常处理中 代表必须执行的部分
 * */
fun test24() {
    try {

    } finally {

    }
}

/**
 * get 声明属性的getter构造器
 * */
val value1: String = ""
    get


/**
 * init 初始化模块声明
 * */
class CD {
    init {

    }
}

/**
 * set 声明属性的setter构造器
 * */
var value2: String = ""
    set

/**
 * where 描述泛型目标需要实现的多重接口
 * */
fun <T> test26(t: T) where T : Comparable<Int>,
                           T : Cloneable,
                           T : Serializable {
}

class TT : Comparable<Int>, Cloneable, Serializable {
    override fun compareTo(other: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun ttt() {
    test26(TT())
}

/**
 * 修饰符关键字
 *
 * 以下符号作为声明中修饰符列表中的关键字，并可用作其他上下文中的标识符：
 *
 * abstract 将一个类或成员标记为抽象
 *
 * annotation 声明一个注解类
 *
 * companion 声明一个伴生对象
 *
 * const 将属性标记为编译期常量
 *
 * crossinline 禁止传递给内联函数的 lambda 中的非局部返回
 *
 * data 指示编译器为类生成典型成员
 *
 * enum 声明一个枚举
 *
 * external 将一个声明标记为不是在 Kotlin 中实现（通过 JNI 访问或者在 JavaScript 中实现）
 *
 * final 禁止成员覆盖
 *
 * infix 允许以中缀表示法调用函数
 *
 * inline 告诉编译器在调用处内联传给它的函数和 lambda 表达式
 *
 * inner 允许在嵌套类中引用外部类实例
 *
 * internal 将一个声明标记为在当前模块中可见
 *
 * lateinit 允许在构造函数之外初始化非空属性
 *
 * noinline 关闭传给内联函数的 lambda 表达式的内联
 *
 * open 允许一个类子类化或覆盖成员
 *
 * operator 将一个函数标记为重载一个操作符或者实现一个约定
 *
 * out 将类型参数标记为协变
 *
 * override 将一个成员标记为超类成员的覆盖
 *
 * private 将一个声明标记为在当前类或文件中可见
 *
 * protected 将一个声明标记为在当前类及其子类中可见
 *
 * public 将一个声明标记为在任何地方可见
 *
 * reified 将内联函数的类型参数标记为在运行时可访问
 *
 * sealed 声明一个密封类（限制子类化的类）
 *
 * suspend 将一个函数或 lambda 表达式标记为挂起式（可用做协程）
 *
 * tailrec 将一个函数标记为尾递归（允许编译器将递归替换为迭代）
 *
 * vararg 允许一个参数传入可变数量的参数
 * */

/**
 * abstract 声明抽象类 和 抽象成员
 * */
abstract class AC {

    abstract var v: String

    abstract fun t()
}

class TAC(override var v: String) : AC() {

    override fun t() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

/**
 * annotation 声明注解类
 * */
annotation class AAAA

/**
 * companion 声明伴生对象
 * */
class CT {
    companion object BS {

    }
}

/**
 * const 顶级声明编译期常量
 * */
const val constValue: String = "fuck"

/**
 * crossinline 禁止传递给内联函数的 lambda 中的非局部返回
 * */
inline fun test27(crossinline f: () -> String) {
    f()
}


/**
 * data 声明数据类
 * */
data class DataC(var name: String)

/**
 * enum 声明枚举
 * */
enum class EC {
    E1, E2
}

/**
 * external 没看到
 * */

/**
 * final 声明为不能重写或不能继承 其实除了接口 抽象的 默认基本都是final
 * */
final class FClass

/**
 * infix 中缀函数 中缀函数一定是 一个参数的扩展函数
 * */
infix fun String.zz(other: String) {

}

fun test28() {
    "123" zz "abc"
}


/**¬
 * inline 声明内联函数
 * */
inline fun test29(f: () -> String) {

}

/**
 * internal 可见性修饰  模块内可见
 * */
internal var inValue = 12

/**
 * lateinit 允许在构造函数之外初始化非空属性
 * */
class LataClass {

    lateinit var lateInitValue: String

    fun test() {
        lateInitValue = "123"
    }
}

/**
 * noinline 关闭传给内联函数的 lambda 表达式的内联
 * */
inline fun inFun(noinline f: () -> String) {
    f()
}


/**
 * crossinline 和 noinline 的区别
 *
 * 现在分析下  个人理解
 *
 * crossinline 是禁止传入的函数做非局部的返回 也就是crossinline修饰 实际上函数还是内联额  只是做引用函数的返回
 * noinline 是关闭内联 就是这样的应用已经不是内联的了
 *
 * 从表现形式上来看 他们两个都不能做引用函数的返回了 但是 他们的本质差别是 内联与否
 *
 * 其实到现在 出来大致的了解内联函数的好处可以提高一些运行性能 还就就是巧妙的注入 基本上不知道好处在哪里  他他妈的麻烦了
 *
 * */
fun tttweq() {
    test27 {
        "1231"
    }

    inFun {
        "1231"
    }

    test29 {
        "12312"
        return
    }
}

/**
 * open 声明类可以被基础 成员可以被重写
 * */
open class OpenClass {

    open var value = 1

    open fun test() {}
}

/**
 * operator 声明重载操作符
 * */
class OPC

operator fun OPC.plus(opc: OPC) {

}

/**
 * out 泛型中时声明协变 生产者
 * */
fun test33(list: ArrayList<out Int>) {

}

/**
 * override 重写标识 不过多说明了
 * */

/**
 * private 可见性声明中 私有
 * */
private var dk = 2

/**
 * public 可见性声明中  公有  默认为public
 * */
public var ss = 2

/**
 * protected 将一个声明标记为在当前类及其子类中可见 受保护 本身和子类可见 所以不能再顶层声明
 * */
class Adasd {
    protected var aa = 1
}

/**
 * reified 将内联函数的类型参数标记为在运行时可访问
 * */
inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

/**
 * sealed 密封类 子类有限 可穷举
 * */
sealed class SealedClass

class SC1 : SealedClass()

class SC2 : SealedClass()

fun test34(t: SealedClass) = when (t) {
    is SC1 -> println("SC1")
    is SC2 -> println("SC2")
}

/**
 * suspend 协程相关  暂时不管
 * */

/**
 * tailrec 尾递归 编译器会将其翻译成循环语句 优化内存消耗
 * */
tailrec fun test35() {
    test35()
}

/**
 * vararg 不定参数声明  类似数组 Array
 * */
fun test36(vararg stringList: String) {

}

fun test37(stringList: Array<String>) {
}