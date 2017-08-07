package com.xue.base.single

/**
 * 这个例子是单例，但是感觉总是有点怪怪的，说不出来哪里怪
 * */
fun main(args: Array<String>) {
    SingleTest.ageAdd()
    SingleTest.ageAdd()

    println("single test Name == ${SingleTest.Name}")
    println("single test age == ${SingleTest.age}")
}

object SingleTest {
    val Name = "single name"

    var age = 10

    fun ageAdd() {
        age++
    }
}

