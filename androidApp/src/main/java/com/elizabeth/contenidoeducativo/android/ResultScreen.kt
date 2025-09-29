package com.elizabeth.contenidoeducativo.android


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elizabeth.contenidoeducativo.android.components.BaseCard
import com.elizabeth.contenidoeducativo.android.components.Footer
import com.elizabeth.contenidoeducativo.android.components.Header

// Modelo de datos
data class Evaluacion(
    val nombre: String,
    val estado: String,
    val progreso: Int
)

@Composable
fun ResultadosScreen() {
    // Datos de ejemplo
    val evaluaciones = listOf(
        Evaluacion("Ana López", "En progreso", 80),
        Evaluacion("Luis Pérez", "Completado", 100),
        Evaluacion("Luis Pérez", "En Progreso", 30)
    )
1
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F4F9)) // Fondo suave
    ) {
        // HEADER
        Header()

        // CONTENIDO PRINCIPAL
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Text(
                text = "Introducción a la Biología",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF003366)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                // LISTA DE EVALUACIONES
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(evaluaciones) { eval ->
                        BaseCard(
                            modifier = Modifier
                                .padding(bottom = 12.dp),
                            onClick = {}
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Evaluación",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )
                                Text(
                                    text = eval.nombre,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = eval.estado,
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "${eval.progreso}%",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color(0xFF003366)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // ANÁLISIS
                Surface(
                    modifier = Modifier
                        .width(150.dp)
                        .fillMaxHeight()
                        .padding(4.dp),
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 8.dp,
                    color = Color(0xFFE8F0FE)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Análisis",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF003366)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("Correctas: 10")
                        Text("Incorrectas: 3")
                        Text("Sin responder: 2")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Total: 10/15")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Tiempo total\n12 min", textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                    }
                }
            }
        }

        // FOOTER
        Footer()
    }
}
