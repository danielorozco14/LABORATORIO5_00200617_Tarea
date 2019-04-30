package com.example.pokedex.utils

import android.net.Uri
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*


class NetworkUtility() {

    val BASE_URL: String = "https://pokeapi.co/api/v2/"

    val URL_ALL: String = "pokemon/?offset=0&limit=300"

    fun buildUrl(externalUrl: String?): URL {
        val builtUri = Uri.parse(externalUrl)

        lateinit var url: URL
        try {
            url = URL(builtUri.toString())
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        return url
    }

    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL): String? {
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val `in` = urlConnection.getInputStream()

            val scanner = Scanner(`in`)
            scanner.useDelimiter("\\A")

            val hasInput = scanner.hasNext()
            if (hasInput) {
                return scanner.next()
            } else {
                return null
            }
        } finally {

            urlConnection.disconnect()
        }
    }


}