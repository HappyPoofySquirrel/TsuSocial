package com.guvyerhopkins.tsusocial.core.login

import com.guvyerhopkins.tsusocial.core.LoggedInUser
import com.guvyerhopkins.tsusocial.core.LoggedInUserDao
import com.guvyerhopkins.tsusocial.core.User
import com.guvyerhopkins.tsusocial.core.UserDao

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(private val userDao: UserDao, private val loggedInUserDao: LoggedInUserDao) {

    fun login(username: String, password: String) {

        if (userDao.getUser(username) == null) {
            userDao.instert(User(username = username, imageUrl = null))
        }

        loggedInUserDao.nukeTable()
        loggedInUserDao.instert(LoggedInUser(username = username, imageUrl = null))
    }
}