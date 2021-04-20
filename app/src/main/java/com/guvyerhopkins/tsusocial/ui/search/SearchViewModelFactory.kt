package com.guvyerhopkins.tsusocial.ui.search


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guvyerhopkins.tsusocial.core.JsonFileParser
import com.guvyerhopkins.tsusocial.ui.home.HomeViewModel

class SearchViewModelFactory(private val jsonFileParser: JsonFileParser) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return SearchViewModel(
                jsonFileParser
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}