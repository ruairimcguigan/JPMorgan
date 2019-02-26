package com.tech.jpmorgan.vo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

@Entity(
    tableName = "Album"
)
data class Album(

    @Json(name = "userId")
    @NonNull
    @PrimaryKey
    val userId: Int,

    @Json(name = "id")
    val id: Int?,

    @Json(name = "title")
    val title: String?)
