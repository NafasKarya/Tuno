package com.tuno_appsmusic.features.auth.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginContent(
    email: String,
    password: String,
    passwordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    navController: NavController,
    titleFontSize: TextUnit,
    bodyFontSize: TextUnit,
    smallFontSize: TextUnit,
    layoutModifier: Modifier
) {
    Column(
        modifier = layoutModifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", fontSize = titleFontSize, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Text("Don't have an account? ", color = Color.Gray, fontSize = bodyFontSize)
            Text(
                "Sign up",
                color = Color(0xFFCCFF00),
                fontSize = bodyFontSize,
                modifier = Modifier.clickable { navController.navigate("register") }
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        LoginFormSection(
            email = email,
            password = password,
            passwordVisible = passwordVisible,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onTogglePasswordVisibility = onTogglePasswordVisibility
        )
        Spacer(modifier = Modifier.height(24.dp))
        LoginButtonSection(fontSize = bodyFontSize)
        Spacer(modifier = Modifier.height(24.dp))
        Divider(color = Color.Gray.copy(alpha = 0.3f))
        Spacer(modifier = Modifier.height(12.dp))
        Text("or sign up with", color = Color.Gray, fontSize = bodyFontSize)
        Spacer(modifier = Modifier.height(12.dp))
        SignWithSection()
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "By clicking continue you agree to recognotes",
            fontSize = smallFontSize,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Terms of use", color = Color(0xFFCCFF00), fontSize = smallFontSize)
            Text(" and ", color = Color.Gray, fontSize = smallFontSize)
            Text("Privacy policy", color = Color(0xFFCCFF00), fontSize = smallFontSize)
        }
    }
}
