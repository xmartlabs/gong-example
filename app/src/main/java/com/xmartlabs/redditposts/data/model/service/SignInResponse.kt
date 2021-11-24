package com.xmartlabs.redditposts.data.model.service

import com.xmartlabs.redditposts.data.model.User

/**
 * Created by mirland on 03/05/20.
 */
data class SignInResponse(val token: String, val user: User)
