package com.elizabeth.contenidoeducativo.android

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFE6F7FF))
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
/*@Preview
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text("Buscar") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(percent = 50))
    )
}*/
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
        subjects.chunked(2).forEach { row ->
            Row(modifier = Modifier.fillMaxWidth()) {
                row.forEach { name ->
                    SubjectCard(name, Modifier.weight(1f).padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun SubjectCard(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { /* Ir a la sección */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF))
        ) {
            Text("Ingresa aquí", color = Color.White)
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
