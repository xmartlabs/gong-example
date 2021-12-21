package com.xmartlabs.redditposts.ui.screens.mainscreen

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text

@Composable
fun MainScreen() {
    MainContent(emptyPage = "Empty Page")
}

@Composable
fun MainContent(
    emptyPage: String,
) {
    Text(
        text = emptyPage,
        style = MaterialTheme.typography.h3,
    )
}
