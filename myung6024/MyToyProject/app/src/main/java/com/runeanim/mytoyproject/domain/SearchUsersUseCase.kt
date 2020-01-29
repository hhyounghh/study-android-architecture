package com.runeanim.mytoyproject.domain

import com.runeanim.mytoyproject.data.Result
import com.runeanim.mytoyproject.data.source.RepositoriesRepository
import com.runeanim.mytoyproject.data.source.remote.response.UsersResponse
import com.runeanim.mytoyproject.util.wrapEspressoIdlingResource

class SearchUsersUseCase(
    private val repositoriesRepository: RepositoriesRepository
) {
    suspend operator fun invoke(searchKeyWord: String): Result<UsersResponse> {
        wrapEspressoIdlingResource {
            return repositoriesRepository.searchUsers(searchKeyWord)
        }
    }
}
