package com.tuno_appsmusic.features.auth.presentation.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tuno_appsmusic.R

@Composable
fun SignWithSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        SocialButton(iconRes = R.drawable.ic_google)
        SocialButton(iconRes = R.drawable.ic_phone)
    }
}
