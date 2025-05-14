package com.tuno_appsmusic.features.auth.presentation.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.tuno_appsmusic.R
import ScreenUtils
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginFormSection(
    email: String,
    password: String,
    passwordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit
) {
    // ✅ Field Email
    TextField(
        value = email,
        onValueChange = onEmailChange,
        placeholder = { Text("Email address", color = Color.Gray) },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.DarkGray,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = LocalTextStyle.current.copy(color = Color.White),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(12.dp)))

    // ✅ Field Password
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text("Password", color = Color.Gray) },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = onTogglePasswordVisibility) {
                val iconRes = if (passwordVisible) R.drawable.ic_visibility_off else R.drawable.ic_visibility_on
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.DarkGray,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = LocalTextStyle.current.copy(
            color = Color.White,
            letterSpacing = 1.5.sp
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

