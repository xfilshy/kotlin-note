package com.xue.base.with

/**
 * main方法中的三种写法都可以实现连续执行方法的效果，但是差别是什么
 * 什么时候用什么  尤其是 apply also 差别是什么
 *
 * 需要之后慢慢品味
 * */
fun main(args: Array<String>) {

    var turtle = Turtle()
    with(turtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    println("with turtle = $turtle")

    turtle.apply {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    println("apply turtle = $turtle")

    turtle.also {
        it.penDown()
        for (i in 1..4) {
            it.forward(100.0)
            it.turn(90.0)
        }
        it.penUp()
    }

    println("also turtle = $turtle")
}

class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}

