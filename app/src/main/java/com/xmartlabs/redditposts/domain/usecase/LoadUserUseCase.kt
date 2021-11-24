package com.xmartlabs.redditposts.domain.usecase

import com.xmartlabs.redditposts.data.model.User
import com.xmartlabs.redditposts.domain.repository.UserRepository
import com.xmartlabs.redditposts.domain.usecase.common.CoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first

/**
 * Created by mirland on 25/04/20.
 */
class LoadUserUseCase(
    private val userRepository: UserRepository,
    dispatcher: CoroutineDispatcher,
) : CoroutineUseCase<Unit, User?>(dispatcher) {
    override suspend fun execute(params: Unit): User? =
        userRepository.getCurrentUser()
            .first()
}
