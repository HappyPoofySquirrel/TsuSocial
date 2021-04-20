package com.guvyerhopkins.tsusocial.core

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoggedInUserDao {

    //currently setup to only ever have one entry
    @Query("SELECT * FROM loggedInUser")
    fun getLoggedInUser(): LoggedInUser

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun instert(user: LoggedInUser)

    @Query("DELETE FROM loggedInUser")
    fun nukeTable()
}

