package com.xue.operator.overloading

/**
 * Kotlin 允许我们为自己的类型提供预定义的一组操作符的实现。这些操作符具有固定的符号表示 （如 + 或 *）和固定的优先级。
 * 为实现这样的操作符，我们为相应的类型（即二元操作符左侧的类型和一元操作符的参数类型）提供了一个固定名字的成员函数或扩展函数。
 * 重载操作符的函数需要用 operator 修饰符标记。
 *
 * 另外，我们描述为不同操作符规范操作符重载的约定。
 * */

/**
 * 操作符 函数 对应
 *
 * 一元运算：
 * +a	a.unaryPlus()
 * -a	a.unaryMinus()
 * !a	a.not()
 * a++  a.inc()
 * a--  a.dec()
 *
 * 二元运算：
 * a + b	a.plus(b)
 * a - b	a.minus(b)
 * a * b	a.times(b)
 * a / b	a.div(b)
 * a % b	a.rem(b)、 a.mod(b) （已弃用）
 * a..b	    a.rangeTo(b)
 *
 * in运算符：
 * a in b	b.contains(a)
 * a !in b  !b.contains(a)
 *
 * 索引运算符：
 * a[i]	a.get(i)
 * a[i, j]	a.get(i, j)
 * a[i_1, ……, i_n]	a.get(i_1, ……, i_n)
 * a[i] = b	a.set(i, b)
 * a[i, j] = b	a.set(i, j, b)
 * a[i_1, ……, i_n] = b	a.set(i_1, ……, i_n, b)
 *
 * */
fun main(args: Array<String>) {

    var point = Point(1, 2)

    println("point = $point")
    println("-point = ${-point}")
    println("!point = ${!point}")

    println()

    println("point = $point")
    println("point++ = ${point++}")
    println("point = $point")

    println()

    println("point = $point")
    println("++point = ${++point}")
    println("point = $point")

    println()

    println("point = $point")
    println("point-- = ${point--}")
    println("point = $point")

    println()

    println("point = $point")
    println("--point = ${--point}")
    println("point = $point")

    println()

    var i = 1
    println("i = $i")
    println("i++ = ${i++}")
    println("i = $i")

    println("point + point = ${point + point}")
    println("point - point = ${point - point}")
    println("point * point = ${point * point}")
    println("point / point = ${point / point}")
    println("point % point = ${point % point}")

    point = Point(0, 2)
    for (p in point..10) {
        println("p == $p")
    }

    println("point in point..-10 = ${point in point..10}")
}

/**
 * 可以在对象内部重载
 * */
data class Point(var x: Int, var y: Int) {

    /**
     * 一元 -a
     * */
    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }

}

/**
 * 也可以以扩展的形式重载 ， 如果没有重载的运算符 编译时会报错的
 * */
operator fun Point.not() = null


/**
 * inc() 和 dec() 函数必须返回一个值，它用于赋值给使用 ++ 或 -- 操作的变量。
 * 它们不应该改变在其上调用 inc() 或 dec() 的对象。（这一点非常的重要 ，不要返回对象本身 ， 要不就没有了 先加减 后加减的差别了）
 *
 * 注意 重载 ++ -- 的时候 谨慎使用 ++ 和 --  如 例子里的  x + 1 不要写成 x++ 是错的
 * */
operator fun Point.inc(): Point {
    return Point(x + 1, y + 1)
}

operator fun Point.dec(): Point {
    return Point(x - 1, y - 1)
}

operator fun Point.plus(point: Point): Point {
    return Point(x + point.x, y + point.y)
}

operator fun Point.minus(point: Point): Point {
    return Point(x - point.x, y - point.y)
}

operator fun Point.times(point: Point): Point {
    return Point(x * point.x, y * point.y)
}

operator fun Point.div(point: Point): Point {
    return Point(x / point.x, y / point.y)
}

operator fun Point.rem(point: Point): Point {
    IntProgression
    return Point(x % point.x, y % point.y)
}

operator fun Point.rangeTo(range: Int) = PointProgression(this, range, 1)

class PointProgression(val start: Point, val range: Int, val step: Int) : Iterable<Point> {
    override fun iterator(): Iterator<Point> = PointProgressionIterator(start, range, step)
}

class PointProgressionIterator(start: Point, range: Int, private val step: Int) : Iterator<Point> {

    var tmp = range

    var hasNext = (range > 0) && (step > 0 || step < 0)

    var next = if (hasNext) start else Point(0, 0)

    override fun hasNext() = hasNext

    override fun next(): Point {
        var tp = next

        tmp -= Math.abs(step)
        next = Point(next.x + step, next.y + step)
        if (tmp < 0) {
            hasNext = false
        }

        return tp
    }

}

operator fun Point.contains(it: Iterator<Point>): Boolean {
    for (p in it) {
        if (p === this) {
            return true
        }
    }

    return false
}