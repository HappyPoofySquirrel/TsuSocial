package com.guvyerhopkins.tsusocial.core.login

import com.guvyerhopkins.tsusocial.core.UserDao

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(private val userDao: UserDao) {

    fun login(username: String, password: String) {
        if (userDao.getUser(username) == null) {
            userDao.instert(username)
        }
    }
}