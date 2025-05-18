package com.tuno_appsmusic.features.auth.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tuno_appsmusic.R

@Composable
fun SignWithSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // X (Twitter)
            IconButton(
                onClick = { /* Handle X login */ },
                modifier = Modifier.size(44.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_x), // pastikan ic_x ada di drawable
                    contentDescription = "Sign in with X",
                    modifier = Modifier.size(40.dp)
                )
            }
            // Google
            IconButton(
                onClick = { /* Handle Google login */ },
                modifier = Modifier.size(44.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Sign in with Google",
                    modifier = Modifier.size(40.dp)
                )
            }
            // Facebook
            IconButton(
                onClick = { /* Handle Facebook login */ },
                modifier = Modifier.size(44.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook), // pastikan ic_facebook ada di drawable
                    contentDescription = "Sign in with Facebook",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}
