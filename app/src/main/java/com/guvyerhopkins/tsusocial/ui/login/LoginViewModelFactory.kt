package com.guvyerhopkins.tsusocial.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guvyerhopkins.tsusocial.core.LoggedInUserDao
import com.guvyerhopkins.tsusocial.core.UserDao
import com.guvyerhopkins.tsusocial.core.login.LoginDataSource
import com.guvyerhopkins.tsusocial.core.login.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory(
    private val userDao: UserDao,
    private val loggedInUserDao: LoggedInUserDao
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource(userDao, loggedInUserDao)
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}