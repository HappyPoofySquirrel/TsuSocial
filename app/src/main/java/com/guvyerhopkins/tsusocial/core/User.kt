package com.guvyerhopkins.tsusocial.core

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val username: String,
    val imageUrl: String? = null
) {

    override fun toString() = username
}
