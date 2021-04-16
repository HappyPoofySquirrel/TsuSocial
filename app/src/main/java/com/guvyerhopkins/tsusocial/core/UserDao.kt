package com.guvyerhopkins.tsusocial.core

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE username = :username")
    fun getUser(username: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun instert(user: User)
}
