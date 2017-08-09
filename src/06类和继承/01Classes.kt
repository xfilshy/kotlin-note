package com.xue.classes

/**
 * 类成员
 * 类可以包含:
 *      构造函数和初始化块
 *      函数
 *      属性
 *      嵌套类和内部类
 *      对象声明
 * */
fun main(args: Array<String>) {
    var t10 = Teacher10()
}

/**
 * 一个类基本的声明形式
 * class 类名 {
 * }
 * */
class Person {

}

/**
 * 声明一个空的类
 * 可以不要类块
 * */
class Student

/**
 * 在 Kotlin 中的一个类可以有一个主构造函数和一个或多个次构造函数。
 * 主构造函数是类头的一部分：它跟在类名（和可选的类型参数）后。
 *
 * */
class Teacher1 private constructor(name: String)

/**
 * 如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
 * */
class Teacher2(name: String)

/**
 * 主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中
 * 注意，主构造的参数可以在初始化块中使用。它们也可以在类体内声明的属性初始化器中使用
 * Teacher3 和 Teacher4 和 Teacher5  应该是完全一样的代码  Teacher3 是最简便的
 * */
class Teacher3(name: String) {

    var name: String = ""

    init {
        this.name = name
    }
}

class Teacher4(name: String) {

    var name: String = name
}

class Teacher5(var name: String) {

}

/**
 * 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
 * */
class Teacher6 public constructor(name: String) {

}

/**
 * 也可以声明次级构造函数
 * 这种情况 没有声明主构造函数 只有次级构造函数 试了一下 不存在默认的无参的主构造函数
 * 暂时先这么理解吧 如果是其他的情况不可见 我们再研究
 * */
class Teacher7 {
    constructor(name: String) {

    }
}

/**
 * 如果有主构造函数，每个次级构造函数必须委托给主构造函数，可以直接委托或者通过别的次构造函数间接委托。
 * */
class Teacher8(name: String) {

    /**
     * 直接委托  委托像不像返回值
     * */
    constructor(name: String, age: Int) : this(name) {

    }

    /**
     * 间接委托
     * */
    constructor(name: String, age: Int, heigh: Float) : this(name, age) {

    }
}

/**
 * 如果没有声明主构造函数和次级构造函数，会默认生成一个无参开放的构造函数，
 * 如果想改变可见性 需要明确的声明
 * */
class Teacher9 private constructor() {
}

/**
 * 在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，它将使用默认值。
 * 这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样的通过无参构造函数创建类的实例的库
 * */
class Teacher10(val name: String = "")