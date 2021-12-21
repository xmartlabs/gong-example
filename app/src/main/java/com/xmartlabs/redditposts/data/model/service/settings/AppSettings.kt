package com.xmartlabs.redditposts.data.model.service.settings

import kotlinx.serialization.Serializable

/**
 * Created by mirland on 14/6/21.
 */
@Serializable
data class AppSettings(
    val sessionToken: String? = null,
)
