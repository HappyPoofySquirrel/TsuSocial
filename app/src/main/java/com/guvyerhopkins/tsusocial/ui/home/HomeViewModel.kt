package com.guvyerhopkins.tsusocial.ui.home

import androidx.lifecycle.ViewModel
import com.guvyerhopkins.tsusocial.R
import com.guvyerhopkins.tsusocial.core.LoggedInUserDao
import java.util.*

class HomeViewModel(private val loggedInUserDao: LoggedInUserDao) : ViewModel() {

    fun getGreeting(): Pair<Int, String> {
        val calendar = Calendar.getInstance()

        val stringResoure = when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> R.string.good_morning
            in 12..17 -> R.string.good_afternoon
            in 18..24 -> R.string.good_evening
            else -> R.string.whoops
        }

        return Pair(stringResoure, loggedInUserDao.getLoggedInUser().username)
    }
}