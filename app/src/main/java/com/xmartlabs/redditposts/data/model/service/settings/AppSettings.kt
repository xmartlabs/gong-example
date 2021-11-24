package com.xmartlabs.redditposts.data.model.service.settings

import com.xmartlabs.redditposts.data.model.User
import kotlinx.serialization.Serializable

/**
 * Created by mirland on 14/6/21.
 */
@Serializable
data class AppSettings(
    val sessionToken: String? = null,
    val sessionUser: User? = null,
)
