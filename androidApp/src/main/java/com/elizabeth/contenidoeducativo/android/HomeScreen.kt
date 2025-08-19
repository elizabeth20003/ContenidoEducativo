package com.elizabeth.contenidoeducativo.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F7FF))
    ) {
        item {
            // Encabezado con título
            Header()
        }

        item {
            // Título principal
            TitleSection()
        }

        item {
            // Tarjetas por categoría
            SubjectGrid()
        }

        item {
            // Footer
            Footer()
        }
    }
}

@Composable
fun Header() {
    // Tarjeta superior del header con color y esquinas redondeadas abajo
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //sombra
            .shadow(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF003366)),
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
    ) {
        // Fila principal: título a la izquierda, botones a la derecha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "EduConecta",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            // Fila secundaria con los botones de navegación
            Row {
                Button(
                    onClick = { /* Navegar a inicio */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF06677F)),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Inicio", color = Color.White, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Navegar a evaluaciones */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF06677F)),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Evaluaciones", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun TitleSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "CONTENIDO EDUCATIVO",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF003366),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Selecciona una materia para comenzar a aprender",
            fontSize = 16.sp,
            color = Color(0xFF0066CC),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun SubjectGrid() {
    // Lista de materias con nombre, ícono y color asociado
    val subjects = listOf(
        Subject("Matemáticas", R.drawable.ic_math, Color(0xFF007BFF)),
        Subject("Español", R.drawable.ic_book, Color(0xFF0066CC)),
        Subject("Ciencias Sociales", R.drawable.ic_globe, Color(0xFF06677F)),
        Subject("Ciencias Naturales", R.drawable.ic_science, Color(0xFF4A9EFF)),
        Subject("Estadística", R.drawable.ic_chart, Color(0xFF0080FF)),
        Subject("Ética", R.drawable.ic_ethics, Color(0xFF005BB5))
    )
   // Contenedor vertical para las tarjetas de materias
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        subjects.forEach { subject ->
            SubjectCard(subject = subject)
        }

        // Espacio extra antes del footer
        Spacer(modifier = Modifier.height(24.dp))
    }
}
// Modelo de datos para representar una materia
data class Subject(
    val name: String,
    val iconRes: Int,
    val color: Color
)

@Composable
fun SubjectCard(subject: Subject) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícono circular con drawable
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(subject.color.copy(alpha = 0.1f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = subject.iconRes),
                    contentDescription = "Icono de ${subject.name}",
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            // Contenido central
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    subject.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF003366)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Toca para aprender",
                    fontSize = 12.sp,
                    color = Color(0xFF0066CC)
                )
            }

            // Botón de acción
            Button(
                onClick = { /* Ir a la sección */ },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF)),
                modifier = Modifier.height(40.dp)
            ) {
                Text(
                    "Entrar",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun Footer() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF003366)),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                " EduConecta 2025",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Plataforma educativa diseñada especialmente\npara estudiantes de zonas rurales",
                fontSize = 12.sp,
                color = Color(0xFFB3E5FC),
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Todos los derechos reservados",
                fontSize = 10.sp,
                color = Color(0xFF0066CC),
                textAlign = TextAlign.Center
            )
        }
    }
}