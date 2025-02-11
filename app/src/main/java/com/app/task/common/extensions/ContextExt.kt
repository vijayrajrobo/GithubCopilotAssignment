package com.app.task.common.extensions

import android.content.Context
import java.io.IOException

fun Context.readJsonFromAssets(fileName: String): String? {
    return try {
        val inputStream = assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charsets.UTF_8)
    } catch (ex: IOException) {
        ex.printStackTrace()
        null
    }
}
