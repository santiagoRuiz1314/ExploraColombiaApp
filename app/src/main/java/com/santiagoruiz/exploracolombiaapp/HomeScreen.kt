package com.santiagoruiz.exploracolombiaapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun HomeScreen(onLogout: () -> Unit = {}) {
    val primaryOrange = Color(0xFFE45D25)
    val lightGrayBg = Color(0xFFF8F9FE)

    val currentUser = Firebase.auth.currentUser
    val email = currentUser?.email ?: ""

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = lightGrayBg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "HOME SCREEN",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Sesión iniciada como:",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = email,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = primaryOrange
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = {
                    Firebase.auth.signOut()
                    onLogout()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(primaryOrange, Color(0xFFFF8A65))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Cerrar sesión",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
