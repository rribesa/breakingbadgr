package br.com.gr.characters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader

fun String.toInputStream() = this::class.java.classLoader?.getResourceAsStream(this)

inline fun <reified T> InputStream.toGson(): T {
    val reader = InputStreamReader(this)
    return Gson().fromJson(reader, object : TypeToken<T>() {}.type)
}

inline fun <reified T> String.toGson() = this.toInputStream()?.toGson<T>()