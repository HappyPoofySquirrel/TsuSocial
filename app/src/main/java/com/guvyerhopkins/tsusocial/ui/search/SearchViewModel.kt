package com.guvyerhopkins.tsusocial.ui.search

import MockUserResult
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guvyerhopkins.tsusocial.core.JsonFileParser

class SearchViewModel(private val jsonFileParser: JsonFileParser) : ViewModel() {

//    var mockUsers: LiveData<PagedList<MockUserResult>>

    init {
        val jsonString = jsonFileParser.getJsonDataFromAsset("mockData.json")

//        val factory: DataSource.Factory<Int, MockUserResult> =
        val gson = Gson()
        val listPersonType = object : TypeToken<List<MockUserResult>>() {}.type

        var persons: List<MockUserResult> = gson.fromJson(jsonString, listPersonType)
//val list = pagedListOf
//        val pagedListBuilder: LivePagedListBuilder<Int, MockUserResult> = LivePagedListBuilder<Int, MockUserResult>(factory, 10)
//        mockUsers = pagedListBuilder.build()
    }
}