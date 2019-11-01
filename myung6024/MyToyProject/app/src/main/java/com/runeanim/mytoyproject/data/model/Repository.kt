package com.runeanim.mytoyproject.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Repository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("language") val language: String?,
    @SerializedName("updated_at") val updatedAt: Date
)
