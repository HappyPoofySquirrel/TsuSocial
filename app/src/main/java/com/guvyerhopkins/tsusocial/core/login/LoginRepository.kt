package com.guvyerhopkins.tsusocial.core.login

import com.guvyerhopkins.tsusocial.ui.login.LoggedInUserView
import com.guvyerhopkins.tsusocial.ui.login.LoginResult

class LoginRepository(val dataSource: LoginDataSource) {

    fun login(username: String, password: String): LoginResult {
        dataSource.login(username, password)
        return LoginResult(LoggedInUserView(username))
    }
}