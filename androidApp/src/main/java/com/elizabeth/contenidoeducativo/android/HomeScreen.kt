package com.elizabeth.contenidoeducativo.android

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F7FF))
    ) {
        // Encabezado
        Header()

        // Campo de búsqueda
        SearchBar()

        // Tarjetas por categoría
        SubjectGrid()

        // Footer
        Footer()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF003366))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            " EduConecta",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { /* Navegar a inicio */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF06677F))
        ) {
            Text("Inicio", color = Color.White)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { /* Navegar a evaluaciones */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF06677F))
        ) {
            Text("Evaluaciones", color = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text("Buscar ") },
        shape = RoundedCornerShape(percent = 50),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF0EDF7),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview
@Composable
fun SubjectGrid() {
    val subjects = listOf(
        "Matemáticas",
        "Español",
        "Ciencias Sociales",
        "Ciencias Naturales",
        "Estadística",
        "Ética"
    )

    Column(modifier = Modifier.padding(16.dp)) {
        subjects.forEach { name ->
            SubjectCard(
                name,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(250.dp)
            )
        }
    }
}

@Composable
fun SubjectCard(name: String = "Materia", modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen o ícono a la izquierda
        // Asegúrate de tener un drawable válido (por ahora usamos un recuadro de color como ejemplo)
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color(0xFFB3E5FC), RoundedCornerShape(8.dp))
        ) {
            // Aquí podrías poner un icono con Image(...)
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Texto y botón a la derecha
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Ir a la sección */ },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF))
            ) {
                Text("Ingresa aquí", color = Color.White)
            }
        }
    }
}

@Composable
fun Footer() {
    Text(
        "© 2025 EduConecta. Todos los derechos reservados.\nPlataforma educativa para zonas rurales con baja conectividad.",
        fontSize = 10.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF003366))
            .padding(8.dp)
    )
}
