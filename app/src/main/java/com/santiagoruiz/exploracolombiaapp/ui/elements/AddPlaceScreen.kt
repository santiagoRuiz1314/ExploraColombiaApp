package com.santiagoruiz.exploracolombiaapp.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santiagoruiz.exploracolombiaapp.ui.theme.ExploraColombiaAppTheme

@Composable
fun AddPlaceScreen(
    onBackClick: () -> Unit = {},
    onPublish: (placeName: String, department: String, city: String, description: String) -> Unit = { _, _, _, _ -> }
) {
    var placeName by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val primaryOrange = Color(0xFFE45D25)
    val lightOrange = Color(0xFFFF8A65)
    val screenBg = Color(0xFFF8F9FE)
    val cardBg = Color(0xFFEFEFF4)
    val inputBg = Color(0xFFE5E5EA)
    val orangeGradient = Brush.verticalGradient(colors = listOf(primaryOrange, lightOrange))

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = screenBg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(top = 16.dp, bottom = 24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.offset(x = (-12).dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        tint = primaryOrange
                    )
                }
                Text(
                    text = "Add Place",
                    color = primaryOrange,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(28.dp))
                    .background(orangeGradient)
                    .padding(horizontal = 24.dp, vertical = 28.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Comparte tu\ndescubrimiento",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        lineHeight = 30.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Ayuda a otros viajeros a encontrar los tesoros escondidos de nuestra tierra.",
                        color = Color.White.copy(alpha = 0.95f),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(cardBg)
                    .padding(20.dp)
            ) {
                AddPlaceField(
                    label = "NOMBRE DEL LUGAR",
                    value = placeName,
                    onValueChange = { placeName = it },
                    placeholder = "Ej: Cascada del Fin del Mundo",
                    inputBg = inputBg
                )

                Spacer(modifier = Modifier.height(20.dp))

                AddPlaceField(
                    label = "DEPARTAMENTO",
                    value = department,
                    onValueChange = { department = it },
                    placeholder = "Ej: Putumayo",
                    inputBg = inputBg
                )

                Spacer(modifier = Modifier.height(20.dp))

                AddPlaceField(
                    label = "CIUDAD",
                    value = city,
                    onValueChange = { city = it },
                    placeholder = "Ej: Mocoa",
                    inputBg = inputBg
                )

                Spacer(modifier = Modifier.height(20.dp))

                AddPlaceField(
                    label = "DESCRIPCIÓN",
                    value = description,
                    onValueChange = { description = it },
                    placeholder = "Cuéntanos por qué este lugar es especial...",
                    inputBg = inputBg,
                    singleLine = false,
                    minHeight = 120.dp
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Button(
                onClick = { onPublish(placeName, department, city, description) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(primaryOrange, lightOrange)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Send,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Publicar",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AddPlaceField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    inputBg: Color,
    singleLine: Boolean = true,
    minHeight: Dp = 56.dp
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = minHeight)
                .clip(RoundedCornerShape(if (singleLine) 28.dp else 20.dp)),
            placeholder = { Text(placeholder, color = Color.Gray) },
            singleLine = singleLine,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = inputBg,
                unfocusedContainerColor = inputBg,
                disabledContainerColor = inputBg,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddPlaceScreenPreview() {
    ExploraColombiaAppTheme {
        AddPlaceScreen()
    }
}
