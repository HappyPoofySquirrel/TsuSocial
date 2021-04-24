package com.guvyerhopkins.tsusocial.ui.home

import com.guvyerhopkins.tsusocial.R
import com.guvyerhopkins.tsusocial.core.LoggedInUser
import com.guvyerhopkins.tsusocial.core.LoggedInUserDao
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*

class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    private lateinit var dao: LoggedInUserDao

    private val calendar = mock(Calendar::class.java)

    private val loggedInUser = LoggedInUser(0, "name", "url")

    @Before
    fun setUp() {
        dao = mock(LoggedInUserDao::class.java)

        viewModel = HomeViewModel(dao)

        `when`(dao.getLoggedInUser()).thenReturn(loggedInUser)
    }

    @Test
    fun testgetMessage_returnsMorning() {
        `when`(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(1)
        val result = viewModel.getGreeting(calendar)
        assert(result.first == R.string.good_morning)
    }

    @Test
    fun testgetMessage_returnsAfternoon() {
        `when`(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(13)
        val result = viewModel.getGreeting(calendar)
        assert(result.first == R.string.good_afternoon)
    }

    @Test
    fun testgetMessage_returnsEvening() {
        `when`(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(21)
        val result = viewModel.getGreeting(calendar)
        assert(result.first == R.string.good_evening)
    }

    @Test
    fun testgetMessage_returnsWhoops() {
        `when`(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(30)
        val result = viewModel.getGreeting(calendar)
        assert(result.first == R.string.whoops)
    }

    @Test
    fun testgetMessage_returnsUsername() {
        val result = viewModel.getGreeting(calendar)
        assert(result.second == loggedInUser.username)
    }
}