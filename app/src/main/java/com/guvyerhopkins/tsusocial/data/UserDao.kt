package com.guvyerhopkins.tsusocial.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE userName = :userName")
    fun getUser(userName: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun instert(user: User)
}
