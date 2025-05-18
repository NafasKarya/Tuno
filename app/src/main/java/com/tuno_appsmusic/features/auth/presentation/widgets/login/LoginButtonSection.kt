package com.tuno_appsmusic.features.auth.presentation.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun LoginButtonSection(fontSize: TextUnit) {
    Button(
        onClick = { /* TODO: handle login */ },
        modifier = Modifier.fillMaxWidth().height(50.dp)
    ) {
        Text("Login", fontSize = fontSize)
    }
}
