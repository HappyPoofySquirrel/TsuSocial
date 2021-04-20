package com.guvyerhopkins.tsusocial.core

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class JsonFileParser(private val context: Context) {
    private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getMockUsers(): List<MockUser> {
        val jsonString = getJsonDataFromAsset("mockData.json")
        val gson = Gson()
        val listPersonType = object : TypeToken<MockUserResult>() {}.type

        val data: MockUserResult = gson.fromJson(jsonString, listPersonType)
        return data.data.users
    }
}