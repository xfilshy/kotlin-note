package com.xue.sealedclass

/**
 * 对于这个密封类的理解，真的不太理解存在的意义
 *
 * 感性的认真就是  密封的所有子类的集合就是密封类的全集  比如  密封类A 他的子类 有B/C/D 那么 Expr就只能有这3种可能
 * 密封类好像不能直接构造出对象
 * */
fun main(args: Array<String>) {

}

/**
 * 密封类用来表示受限的类继承结构：当一个值为有限集中的类型、而不能有任何其他类型时。
 * 在某种意义上，他们是枚举类的扩展：枚举类型的值集合也是受限的，但每个枚举常量只存在一个实例，而密封类的一个子类可以有可包含状态的多个实例。
 * 要声明一个密封类，需要在类名前面添加 sealed 修饰符。虽然密封类也可以有子类，但是所有子类都必须在与密封类自身相同的文件中声明。
 * */
sealed class Expr()

open class Test : Expr()

class Testt : Test()

data class Const(val number: Double) : Expr()

data class Sum(val e1: Expr, val e2: Expr) : Expr()

object NotANumber : Expr()

/**
 * 请注意，扩展密封类子类的类（间接继承者）可以放在任何位置，而无需在同一个文件中。
 * 使用密封类的关键好处在于使用 when 表达式 的时候，如果能够验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了。
 * 当然，这只有当你用 when 作为表达式（使用结果）而不是作为语句时才有用。
 *
 * eval1 注意 eval2 两个函数的差别  其实还真不太理解这样的差别
 * */
fun eval1(expr: Expr): Double = when (expr) {
    is Testt -> 0.0
    is Test -> 0.0
    is Const -> expr.number
    is Sum -> eval1(expr.e1) + eval1(expr.e2)
    NotANumber -> Double.NaN
// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}

fun eval2(expr: Expr): Double {
    when (expr) {
        is Const -> expr.number
        is Sum -> eval2(expr.e1) + eval2(expr.e2)
        NotANumber -> Double.NaN
    }

    return 0.0
}