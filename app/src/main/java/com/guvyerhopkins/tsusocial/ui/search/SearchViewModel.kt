package com.guvyerhopkins.tsusocial.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guvyerhopkins.tsusocial.core.JsonFileParser
import com.guvyerhopkins.tsusocial.core.MockUser

class SearchViewModel(jsonFileParser: JsonFileParser) : ViewModel() {

    private val _mockUsers = MutableLiveData<List<MockUser>>()
    val mockUsers: LiveData<List<MockUser>> = _mockUsers

    init {
        _mockUsers.value =
            jsonFileParser.getMockUsers() //move this class into a repository/data source pattern
    }
}