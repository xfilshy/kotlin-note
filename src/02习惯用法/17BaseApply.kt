package com.xue.base.apply

/**
 * apply also let 等的源码很有意思 可以仔细研究 有大用
 * 但是现在就不深究了 后面再细细琢磨
 * */
fun main(args: Array<String>) {
    println(A(0, 0).apply {
        this.a = 2
        this.b = 3
    })

    println(A(1, 1).also {
        it.a = 2
        it.b = 2
    })

    println(A(1, 1).let {
        it.a = 2
        it.b = 2
    })
}

fun arrayOfMinusOnes(size: Int): A {
    return A(0, 0).apply {
        this.a = 2
        this.b = 3
    }

}

data class A(var a: Int, var b: Int)