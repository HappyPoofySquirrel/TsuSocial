package com.guvyerhopkins.tsusocial.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val userId: String,
    val userName: String,
    val imageUrl: String = ""
) {

    override fun toString() = userName
}