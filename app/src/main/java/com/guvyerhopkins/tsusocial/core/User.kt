package com.guvyerhopkins.tsusocial.core

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val userId: String,
    val userName: String,
    val imageUrl: String? = null
) {

    override fun toString() = userName
}
