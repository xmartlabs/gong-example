package com.xmartlabs.redditposts.device.di

import com.xmartlabs.redditposts.domain.usecase.GetLocationUseCase
import com.xmartlabs.redditposts.domain.usecase.GetSessionTypeUseCase
import com.xmartlabs.redditposts.domain.usecase.LoadUserUseCase
import com.xmartlabs.redditposts.domain.usecase.SignInUseCase
import com.xmartlabs.redditposts.domain.usecase.TimeTrackerUseCase
import org.koin.dsl.module

/**
 * Created by mirland on 25/04/20.
 */
object UseCaseDiModule {
    val useCases = module {
        factory { GetLocationUseCase(get(), get(DEFAULT_DISPATCHER)) }
        factory { GetSessionTypeUseCase(get(), get(DEFAULT_DISPATCHER)) }
        factory { LoadUserUseCase(get(), get(DEFAULT_DISPATCHER)) }
        factory { SignInUseCase(get(), get(DEFAULT_DISPATCHER)) }
        factory { TimeTrackerUseCase(get(DEFAULT_DISPATCHER)) }
    }
}
