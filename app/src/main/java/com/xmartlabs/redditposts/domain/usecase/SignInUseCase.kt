package com.xmartlabs.redditposts.domain.usecase

import com.xmartlabs.redditposts.data.model.User
import com.xmartlabs.redditposts.domain.repository.UserRepository
import com.xmartlabs.redditposts.domain.usecase.common.CoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by mirland on 25/04/20.
 */
class SignInUseCase(
    private val userRepository: UserRepository,
    dispatcher: CoroutineDispatcher,
) : CoroutineUseCase<SignInUseCase.Params, User>(dispatcher) {
    data class Params(val id: String, val password: String)

    override suspend fun execute(params: Params): User = userRepository.signIn(params.id, params.password)
}
