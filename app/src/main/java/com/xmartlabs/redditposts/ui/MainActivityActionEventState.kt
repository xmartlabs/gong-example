package com.xmartlabs.redditposts.ui

import androidx.compose.runtime.Immutable
import com.xmartlabs.redditposts.domain.usecase.SessionType

/**
 * Created by mirland on 10/8/21.
 */
sealed class MainActivityEvent

sealed class MainActivityUiAction

@Immutable
data class SplashViewState(val sessionType: SessionType?)
