package com.xue.collections

import kotlin.collections.List

/**
 * Kotlin 区分可变集合和不可变集合（lists、sets、maps 等）。精确控制什么时候集合可编辑有助于消除 bug 和设计良好的 API
 * 预先了解一个可变集合的只读 视图 和一个真正的不可变集合之间的区别是很重要的。它们都容易创建，但类型系统不能表达它们的差别，所以由你来跟踪（是否相关）
 *
 * Kotlin 的 List<out T> 类型是一个提供只读操作如 size、get等的接口。和 Java 类似，它继承自 Collection<T> 进而继承自 Iterable<T>。
 * 改变 list 的方法是由 MutableList<T> 加入的。这一模式同样适用于 Set<out T>/MutableSet<T> 及 Map<K, out V>/MutableMap<K, V>
 *
 * 下面是 List<out E> 和 MutableList<T>的源码 仔细看看他们的关系 还是很巧妙的
 * */
fun main(args: Array<String>) {

}

/**
 * 一个只读的list的声明 泛型中的 只读 out E 输出声明形式  也叫生产者声明
 * */
/*public interface List<out E> : Collection<E> {
    // Query Operations
    override val size: Int

    override fun isEmpty(): Boolean
    override fun contains(element: @UnsafeVariance E): Boolean
    override fun iterator(): Iterator<E>

    // Bulk Operations
    override fun containsAll(elements: Collection<@UnsafeVariance E>): Boolean

    // Positional Access Operations
    */
/**
 * Returns the element at the specified index in the list.
 */
/*
    public operator fun get(index: Int): E

    // Search Operations
    */
/**
 * Returns the index of the first occurrence of the specified element in the list, or -1 if the specified
 * element is not contained in the list.
 */
/*
    public fun indexOf(element: @UnsafeVariance E): Int

    */
/**
 * Returns the index of the last occurrence of the specified element in the list, or -1 if the specified
 * element is not contained in the list.
 */
/*
    public fun lastIndexOf(element: @UnsafeVariance E): Int

    // List Iterators
    */
/**
 * Returns a list iterator over the elements in this list (in proper sequence).
 */
/*
    public fun listIterator(): ListIterator<E>

    */
/**
 * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified [index].
 */
/*
    public fun listIterator(index: Int): ListIterator<E>

    // View
    */
/**
 * Returns a view of the portion of this list between the specified [fromIndex] (inclusive) and [toIndex] (exclusive).
 * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa.
 *
 * Structural changes in the base list make the behavior of the view undefined.
 */
/*
    public fun subList(fromIndex: Int, toIndex: Int): List<E>
}*/

/**
 * 可变的list声明
 * A generic ordered collection of elements that supports adding and removing elements.
 * @param E the type of elements contained in the list. The mutable list is invariant on its element type.
 */
/*public interface MutableList<E> : List<E>, MutableCollection<E> {
    // Modification Operations
    override fun add(element: E): Boolean

    override fun remove(element: E): Boolean

    // Bulk Modification Operations
    override fun addAll(elements: Collection<E>): Boolean

    */
/**
 * Inserts all of the elements in the specified collection [elements] into this list at the specified [index].
 *
 * @return `true` if the list was changed as the result of the operation.
 */
/*
    public fun addAll(index: Int, elements: Collection<E>): Boolean

    override fun removeAll(elements: Collection<E>): Boolean
    override fun retainAll(elements: Collection<E>): Boolean
    override fun clear(): Unit

    // Positional Access Operations
    */
/**
 * Replaces the element at the specified position in this list with the specified element.
 *
 * @return the element previously at the specified position.
 */
/*
    public operator fun set(index: Int, element: E): E

    */
/**
 * Inserts an element into the list at the specified [index].
 */
/*
    public fun add(index: Int, element: E): Unit

    */
/**
 * Removes an element at the specified [index] from the list.
 *
 * @return the element that has been removed.
 */
/*
    public fun removeAt(index: Int): E

    // List Iterators
    override fun listIterator(): MutableListIterator<E>

    override fun listIterator(index: Int): MutableListIterator<E>

    // View
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E>
}*/


/**
 * Kotlin 没有专门的语法结构创建 list 或 set。 要用标准库的方法，如 listOf()、 mutableListOf()、 setOf()、 mutableSetOf()。
 * 在非性能关键代码中创建 map 可以用一个简单的惯用法来完成：mapOf(a to b, c to d)
 * 注意下面的 readOnlyView 变量（译者注：与对应可变集合变量 numbers）指向相同的底层 list 并会随之改变。
 * 如果一个 list 只存在只读引用，我们可以考虑该集合完全不可变。
 * */
fun test1() {
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers
    println(numbers)        // 输出 "[1, 2, 3]"
    numbers.add(4)
    println(readOnlyView)   // 输出 "[1, 2, 3, 4]"
    //readOnlyView.clear()    // -> 不能编译 因为List<Int>为只读的 不能有任何的写操作

    val strings = hashSetOf("a", "b", "c", "c")
    assert(strings.size == 3)
}

open class A

open class B : A()

open class C : B()

/**
 * 再分析一次
 * Array<out T>只读list  <out T> 和 java的 <? extend T> 类似
 * 是一个T或T的子类的Array
 * 在get获取时 获得都是 T的子类 这些子类都是T 所以 访问是安全的
 * 在set的时候 这是一个T的子类的List ，但是无法确定子类是谁 所以 set的时候是不安全的
 *
 * Array<in T>的话  <in T> 和 java的 <? super T> 类似
 * 是一个T或T的父类的Array
 * 在get获取时 获取的是 T或T的父类 所以获取的对象安全的表达 统一都是 Any 所有对象的超类
 * 在set的时候 设置一个T可以安全的满足 T 一定是 T本身或者T的超类
 *
 * Array<T>的话 因为读写不可控 所以不支持任何的协变
 * Array<A> 和 Array<B> 没有继承关系
 *
 * 这里为什么没用List 因为 我们应用到的List 本身就是 List<out T> 的
 * */
fun test2() {
    /**
     * 只读list的协变
     * */
    var listB: List<B> = listOf(B(), B())
    var listA: List<A> = listB

    /**
     * 可变list的不可协变
     * */
    var mListB: MutableList<B> = mutableListOf(B(), B())
//    var mListA: MutableList<A> = mListB   编译报错
}

/**
 * 再感受一下泛型吧
 * */
fun test3() {
    var outArray: Array<out B> = arrayOf(B())
    var inArray: Array<in B> = arrayOf(B())
    var noArray: Array<B> = arrayOf(B())

    var v1 = outArray[0]
    var v2 = inArray[0] //获取的对象 最安全的就是向上的 Any
    var v3 = noArray[0]

    //outArray[0] = B() 因为没有安全的类型设置
    inArray[0] = B()
    noArray[0] = B()
}

class Controller {
    /**
     * 真实数据实体
     * */
    private val _items = mutableListOf<String>()

    /**
     * 提供给外界查看的实体快照
     * */
    val items: List<String> get() = _items.toList()
}

fun test4() {
    val items = listOf(1, 2, 3, 4)
    items.first() //== 1
    items.last() //== 4
    items.filter { it % 2 == 0 }   // 返回 [2, 4]

    val rwList = mutableListOf(1, 2, 3)
    rwList.requireNoNulls()        // 返回 [1, 2, 3]  //检查是否有空元素 有抛异常
    if (rwList.none { it > 6 }) println("No items above 6")  // 输出“No items above 6” //没有一个满足lambda表达式 返回 true
    val item = rwList.firstOrNull()  //返回第一个 或者 null list为空就返回空了
}


