package example

import org.w3c.fetch.RequestInit
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    document.getElementById("get")!!.addEventListener("click", { event ->
        getExample()
    })

    document.getElementById("post")!!.addEventListener("click", { event ->
        postExample()
    })
}

private fun getExample() {
    console.log("---- getExample ----")
    console.log("fetch 'package.json' with 'get'")
    window.fetch("package.json").then { res ->
        res.text().then { console.log(it) }
    }
}

private fun postExample() {
    console.log("---- postExample ----")
    console.log("fetch 'package.json' with 'post'")
    window.fetch("package.json", JsObj<RequestInit>().apply {
        method = "POST"
        body = JsObj().apply {
            this["key"] = "value"
        }
    }).then { res ->
        res.text().then { console.log(it) }
    }
}

private inline fun <T> JsObj(): T = js("{}") as T
private inline fun JsObj(): JsObj = js("{}") as JsObj

interface JsObj {
    operator fun get(key: String): dynamic
    operator fun set(s: String, value: dynamic)
}