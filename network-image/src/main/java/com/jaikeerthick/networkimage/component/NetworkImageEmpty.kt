package com.jaikeerthick.networkimage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun NetworkImageEmpty(){
    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colors.onSurface
            ),
    )
}