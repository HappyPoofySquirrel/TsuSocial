package com.guvyerhopkins.tsusocial.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guvyerhopkins.tsusocial.core.JsonFileParser
import com.guvyerhopkins.tsusocial.core.MockUser

class SearchViewModel(jsonFileParser: JsonFileParser) : ViewModel(), SearchItemClickListner {

    private val _mockUsers = MutableLiveData<List<MockUser>>()
    val mockUsers: LiveData<List<MockUser>> = _mockUsers

    private val _selectedUser = MutableLiveData<MockUser>()
    val selectedUser: LiveData<MockUser> = _selectedUser

    init {
        _mockUsers.value =
            jsonFileParser.getMockUsers() //move this class into a repository/data source pattern
    }

    override fun onClick(mockUser: MockUser) {
        _selectedUser.value = mockUser
    }
}