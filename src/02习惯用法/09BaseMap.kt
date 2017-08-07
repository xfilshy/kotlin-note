package com.xue.base.map
/**
 * 类似数组的访问方式，和python很像
 * */
fun main(args: Array<String>) {
    var map = mutableMapOf("k1" to 1, "k2" to 2)

    map["k3"] = 3
    map["k1"] = 10

    println("map k1 value = ${map["k1"]}")
    println("map k3 value = ${map["k3"]}")
}