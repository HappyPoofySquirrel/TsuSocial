package com.guvyerhopkins.tsusocial.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guvyerhopkins.tsusocial.core.LoggedInUserDao

class HomeViewModelFactory(private val loggedInUserDao: LoggedInUserDao) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(
                loggedInUserDao
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}