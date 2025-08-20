package com.elizabeth.contenidoeducativo.android

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elizabeth.contenidoeducativo.android.components.*


@Composable
fun ResultScreen() {
    // Data classes
    data class EvaluationData(
        val studentName: String,
        val status: String,
        val percentage: Int
    )

    data class AnalysisData(
        val correctAnswers: Int,
        val incorrectAnswers: Int,
        val unanswered: Int,
        val total: Int,
        val totalTime: String
    )

    // EvaluationCard usando BaseCard
    @Composable
    fun EvaluationCard(
        evaluation: EvaluationData,
        modifier: Modifier = Modifier,
        onClick: () -> Unit = {}
    ) {
        // Determinar colores según el estado
        val (backgroundColor, progressColor) = when (evaluation.status) {
            "Completado" -> Pair(Color(0xFFF3F0FF), Color(0xFF7C3AED)) // Morado claro y morado
            else -> Pair(Color(0xFFF8FAFC), Color(0xFF3B82F6)) // Gris claro y azul
        }

        // Wrapper con fondo personalizado
        Box(
            modifier = modifier
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            BaseCard(onClick = onClick) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // Etiqueta "Evaluación"
                    Text(
                        text = "Evaluación",
                        fontSize = 11.sp,
                        color = Color(0xFF6B7280),
                        modifier = Modifier
                            .background(
                                color = Color(0xFFF1F5F9),
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Nombre del estudiante
                    Text(
                        text = evaluation.studentName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF1F2937)
                    )

                    // Estado
                    Text(
                        text = evaluation.status,
                        fontSize = 13.sp,
                        color = Color(0xFF6B7280)
                    )
                }

                // Indicador circular
                CircularProgressIndicator(
                    percentage = evaluation.percentage,
                    color = progressColor
                )
            }
        }
    }



    // AnalysisCard usando BaseCard
    @Composable
    fun AnalysisCard(
        analysis: AnalysisData,
        modifier: Modifier = Modifier
    ) {
        BaseCard(modifier = modifier) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Análisis",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2937)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Respuestas",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1F2937)
                )

                Spacer(modifier = Modifier.height(12.dp))

                AnalysisRow("Correctas:", analysis.correctAnswers.toString(), Color(0xFF059669))
                Spacer(modifier = Modifier.height(4.dp))
                AnalysisRow("Incorrectas:", analysis.incorrectAnswers.toString(), Color(0xFFDC2626))
                Spacer(modifier = Modifier.height(4.dp))
                AnalysisRow("Sin responder:", analysis.unanswered.toString(), Color(0xFF6B7280))
                Spacer(modifier = Modifier.height(4.dp))
                AnalysisRow(
                    "Total:",
                    "${analysis.total}/15",
                    Color(0xFF1F2937),
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Tiempo total",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1F2937)
                )

                Text(
                    text = analysis.totalTime,
                    fontSize = 14.sp,
                    color = Color(0xFF6B7280),
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }


    // SearchBar - Este no usa BaseCard porque necesita un diseño diferente
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SearchBar(
        query: String,
        onQueryChange: (String) -> Unit,
        placeholder: String = "Buscar Estudiante",
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color(0xFF9CA3AF),
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    cursorColor = Color(0xFF3B82F6)
                ),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF1F2937)
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color(0xFF9CA3AF),
                        modifier = Modifier.size(20.dp)
                    )
                }
            )
        }
    }

    // TitleSection
    @Composable
    fun TitleSection(
        title: String,
        modifier: Modifier = Modifier
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F2937),
            modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        )
    }
}

@Composable
fun AnalysisRow(
    label: String,
    value: String,
    color: Color,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color(0xFF6B7280)
        )
        Text(
            text = value,
            fontSize = 14.sp,
            color = color,
            fontWeight = fontWeight
        )
    }
}
// CircularProgressIndicator personalizado
@Composable
fun CircularProgressIndicator(
    percentage: Int,
    color: Color,
    modifier: Modifier = Modifier,
    strokeWidth: Float = 6f
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(64.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasSize = size.minDimension
            val radius = (canvasSize / 2) - strokeWidth * 2
            val center = androidx.compose.ui.geometry.Offset(
                x = size.width / 2,
                y = size.height / 2
            )

            // Background circle
            drawCircle(
                color = Color(0xFFE5E7EB),
                radius = radius,
                center = center,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )

            // Progress arc
            val sweepAngle = (percentage / 100f) * 360f
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = androidx.compose.ui.geometry.Offset(
                    x = center.x - radius,
                    y = center.y - radius
                ),
                size = androidx.compose.ui.geometry.Size(radius * 2, radius * 2)
            )
        }

        Text(
            text = "$percentage%",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F2937)
        )
    }
}