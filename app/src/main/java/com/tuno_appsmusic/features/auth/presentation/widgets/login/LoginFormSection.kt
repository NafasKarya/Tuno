package com.tuno_appsmusic.features.auth.presentation.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginFormSection(
    email: String,
    password: String,
    passwordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit
) {
    val softBorder = Color(0xFFE0E0E0)
    val focusedBorder = Color(0xFFBDBDBD)
    val labelColor = Color(0xFF757575)
    val iconColor = Color(0xFF9E9E9E)
    val background = Color.White

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Phone/Email Id", color = labelColor) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon",
                    tint = iconColor
                )
            },
            shape = RoundedCornerShape(28.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = softBorder,
                focusedBorderColor = focusedBorder,
                unfocusedContainerColor = background,
                focusedContainerColor = background,
                cursorColor = focusedBorder,
                focusedLabelColor = labelColor,
                unfocusedLabelColor = labelColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Password", color = labelColor) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon",
                    tint = iconColor
                )
            },
            trailingIcon = {
                val icon = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                IconButton(onClick = onTogglePasswordVisibility) {
                    Icon(
                        icon,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = iconColor
                    )
                }
            },
            shape = RoundedCornerShape(28.dp),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = softBorder,
                focusedBorderColor = focusedBorder,
                unfocusedContainerColor = background,
                focusedContainerColor = background,
                cursorColor = focusedBorder,
                focusedLabelColor = labelColor,
                unfocusedLabelColor = labelColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}
