package com.santiagoruiz.exploracolombiaapp.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickAddPlace : ()-> Unit
) {
    Scaffold(
        topBar = {TopAppBar(title = {Text("Explora Colombia")})},
        floatingActionButton = {FloatingActionButton(onClick = {onClickAddPlace()}) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }}
    ) {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)){

        }
    }
}
