package com.xue.builder

/**
 * 类型安全的构建器 这实际是一种结合lambda表达式的代码写作模式  很适合用来构建  html xml json 之类的结构文本
 * */
fun main(args: Array<String>) {
    println("result == \n${result(arrayOf("23", "231", "321313"))}")
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


fun test() = jsonObject {

}

open class JsonElement {

}

class JsonObject : JsonElement() {
    var map = mutableMapOf<String, Any?>()

    fun string(key: String, value: String) {

    }

    fun int(key: String, value: Int) {

    }

    fun `object`(key: String, value: JsonObject) {

    }

    fun array(key: String, value: JsonArray) {

    }
}

class JsonArray {
    var list = mutableListOf<Any?>()
}

fun jsonObject(init: () -> Unit): JsonObject {
    val jsonObject = JsonObject()
    return jsonObject
}

fun jsonArray(init: () -> Unit): JsonArray {
    val jsonArray = JsonArray()
    return jsonArray
}



