package com.runeanim.mytoyproject.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.runeanim.mytoyproject.data.model.User

data class UsersResponse(
    val incomplete_results: Boolean,
    val users: List<User>,
    @SerializedName("total_count") val totalCount: Int
)