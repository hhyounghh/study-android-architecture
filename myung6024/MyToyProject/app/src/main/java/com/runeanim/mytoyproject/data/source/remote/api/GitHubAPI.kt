package com.runeanim.mytoyproject.data.source.remote.api

import com.runeanim.mytoyproject.data.model.Owner
import com.runeanim.mytoyproject.data.model.Repository
import com.runeanim.mytoyproject.data.source.remote.response.RepositoriesResponse
import com.runeanim.mytoyproject.data.source.remote.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPI {

    @GET("/search/repositories")
    suspend fun searchRepositories(@Query("q") searchKeyWord: String): RepositoriesResponse

    @GET("/search/users")
    suspend fun searchUsers(@Query("q") searchKeyWord: String): UsersResponse

    @GET("repos/{repoUrl}")
    suspend fun getRepositoryInfo(@Path("repoUrl", encoded = true) repoUrl: String): Repository

    @GET("users/{id}")
    suspend fun getUserInfo(@Path("id") userUrl: String): Owner

}
