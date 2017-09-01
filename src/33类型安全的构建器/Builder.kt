package com.xue.builder

/**
 * 类型安全的构建器 这实际是一种结合lambda表达式的代码写作模式  很适合用来构建  html xml json 之类的结构文本
 * */
fun main(args: Array<String>) {
//    println("result == \n${result(arrayOf("23", "231", "321313"))}")

    println("test() == ${test()}")
}


fun result(args: Array<String>) =
        html {
            head {
                title { +"XML encoding with Kotlin" }
            }
            body {
                h1 { +"XML encoding with Kotlin" }
                p { +"this format can be used as an alternative markup to XML" }

                // 一个具有属性和文本内容的元素
                a(href = "http://kotlinlang.org") { +"Kotlin" }

                // 混合的内容
                p {
                    +"This is some"
                    b { +"mixed" }
                    +"text. For more see the"
                    a(href = "http://kotlinlang.org") { +"Kotlin" }
                    +"project"
                }
                p { +"some text" }

                // 以下代码生成的内容
                p {
                    for (arg in args)
                        +arg
                }
            }
        }

interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class TextElement(val text: String) : Element {

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }

}

open class Tag(val tag: String) : Element {

    var tags = mutableListOf<Element>()

    var attributes = mutableMapOf<String, String>()

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        tags.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$tag")
        attributes.forEach { (k, v) -> builder.append(" $k=$v") }
        builder.append(">\n")
        tags.forEach { tag -> tag.render(builder, "    " + indent) }
        builder.append("$indent<\\$tag>\n")
    }

    operator fun String.unaryPlus() {
        tags.add(TextElement(this))
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

class HTML : Tag("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)

    fun body(init: Body.() -> Unit) = initTag(Body(), init)
}

class Head : Tag("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init)
}

class Body : Tag("body") {
    fun h1(init: H1.() -> Unit) = initTag(H1(), init)

    fun p(init: P.() -> Unit) = initTag(P(), init)

    fun a(href: String, init: A.() -> Unit) {
        var a = A()
        a.attributes["href"] = href
        initTag(a, init)
    }
}

class Title : Tag("title")

class H1 : Tag("h1")

class P : Tag("p") {

    fun b(init: B.() -> Unit) = initTag(B(), init)

    fun a(href: String, init: A.() -> Unit) {
        var a = A()
        a.attributes["href"] = href
        initTag(a, init)
    }
}

class A : Tag("a")

class B : Tag("b")

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}


/**
 *
 * 以下是模仿 html builder 做的一个 json builder
 *
 * 其实最主要的就是熟悉 高级函数 和 控制的调用特点
 * */


fun test() = createJsonObject {
    string("name") { "xueliyu" }
    int("age") { 30 }
    jsonObject("parent") {
        string("father") { "xuebabab" }
        string("mather") { "xuemama" }
    }
    jsonArray("school") {
        string { "puanxiaoxue" }
        string { "jiangezhongxue" }
        string { "mianyangzhongxue" }
        string { "heilongjiangdaxue" }
    }
}

abstract class JsonElement(val name: String?) {

    abstract fun render(builder: StringBuilder, indent: String)

}

class JsonSimple<T>(name: String?, val value: T?) : JsonElement(name) {

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent")
        if (name !== null) builder.append("$name : ")
        builder.append("${if (value is String) "\"$value\"" else value?.toString()}")
    }
}

open class JsonGroup(name: String?, val border: String) : JsonElement(name) {

    var list = mutableListOf<JsonElement>()

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent")
        if (name !== null) builder.append("$name : ")
        builder.append("${border[0]}\n")
        list.forEachIndexed { index, jsonElement ->
            if (index == list.size - 1) {
                jsonElement.render(builder, indent + "    ")
            } else {
                jsonElement.render(builder, indent + "    ")
                builder.append(",\n")
            }
        }
        builder.append("\n$indent${border[1]}")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

    fun <T> init(jsonGroup: T, init: T.() -> Unit): T {
        jsonGroup.init()
        return jsonGroup
    }
}

class JsonObject(name: String?) : JsonGroup(name, "{}") {

    constructor() : this(null)

    fun string(key: String, value: () -> String) {
        list.add(JsonSimple(key, value()))
    }

    fun int(key: String, value: () -> Int) {
        list.add(JsonSimple(key, value()))
    }

    fun jsonObject(key: String, init: JsonObject.() -> Unit) {
        list.add(init(JsonObject(key), init))
    }

    fun jsonArray(key: String, init: JsonArray.() -> Unit) {
        list.add(init(JsonArray(key), init))
    }
}

class JsonArray(name: String?) : JsonGroup(name, "[]") {

    constructor() : this(null)

    fun string(value: () -> String) {
        list.add(JsonSimple(null, value()))
    }

    fun int(value: () -> Int) {
        list.add(JsonSimple(null, value()))
    }

    fun jsonObject(init: JsonObject.() -> Unit) {
        list.add(init(JsonObject(null), init))
    }

    fun jsonArray(init: JsonArray.() -> Unit) {
        list.add(init(JsonArray(null), init))
    }

}

fun createJsonObject(init: JsonObject.() -> Unit): JsonObject {
    val jsonObject = JsonObject()
    jsonObject.init()
    return jsonObject
}

fun createJsonArray(init: JsonArray.() -> Unit): JsonArray {
    val jsonArray = JsonArray()
    jsonArray.init()
    return jsonArray
}