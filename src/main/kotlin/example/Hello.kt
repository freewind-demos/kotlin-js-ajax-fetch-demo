package example

import kotlinjs.common.jsonAs
import org.w3c.fetch.RequestInit
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.json

fun main(args: Array<String>) {
    document.getElementById("get")!!.addEventListener("click", { _ ->
        getExample()
    })

    document.getElementById("post")!!.addEventListener("click", { _ ->
        postExample()
    })
}

private fun getExample() {
    console.log("---- getExample ----")
    console.log("fetch 'data.json' with 'get'")
    window.fetch("/data.json").then { res ->
        res.text().then { console.log(it) }
    }
}

private fun postExample() {
    console.log("---- postExample ----")
    console.log("fetch 'data.json' with 'post'")
    window.fetch("/data.json", jsonAs<RequestInit>().apply {
        method = "POST"
        headers = json().apply {
            this["Content-Type"] = "application/json"
        }
        body = JSON.stringify(json().apply {
            this["clientData"] = "I'm posted by client"
        })
    }).then { res ->
        res.text().then { console.log(it) }
    }
}
