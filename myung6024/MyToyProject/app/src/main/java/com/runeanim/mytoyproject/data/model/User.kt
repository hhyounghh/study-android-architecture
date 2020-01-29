package com.runeanim.mytoyproject.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("followers_url") val followersUrl: String,
    @SerializedName("gravatar_id") val gravatarId: String,
    @SerializedName("html_url")  val htmlUrl: String,
    val id: Int,
    val login: String,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("organizations_url") val organizationsUrl: String,
    @SerializedName("received_events_url") val received_eventsUrl: String,
    @SerializedName("repos_url") val reposUrl: String,
    val score: Double,
    @SerializedName("subscriptions_url") val subscriptionsUrl: String,
    val type: String,
    val url: String
)