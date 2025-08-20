package com.elizabeth.contenidoeducativo.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elizabeth.contenidoeducativo.android.components.Footer
import com.elizabeth.contenidoeducativo.android.components.Header
import com.elizabeth.contenidoeducativo.android.data.Subject
import com.elizabeth.contenidoeducativo.android.data.SubjectRepository
import com.elizabeth.contenidoeducativo.android.utils.handleSubjectNavigation
import kotlin.collections.forEach
import androidx.compose.foundation.layout.width
import androidx.compose.ui.tooling.preview.Preview
import com.elizabeth.contenidoeducativo.android.components.BaseCard



@Composable
fun HomeScreen() {
    // Usando remember para evitar recrear la lista en cada recomposición
    val subjects = remember { SubjectRepository.getAvailableSubjects() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F7FF))
    ) {
        item {
            Header()
        }

        item {
            TitleSection()
        }

        // Usando items() para renderizado eficiente de la lista
        item {
            SubjectGrid (subjects = subjects, onSubjectClick = { /* acción al hacer clic */ })
        }

        item {
            Footer()
        }
    }
}


@Composable
 fun NavigationButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF06677F)),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier.height(36.dp)
    ) {
        Text(text, color = Color.White, fontSize = 12.sp)
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
fun SubjectGrid(subjects: List<Subject>,onSubjectClick: (Subject) -> Unit) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        subjects.forEach { subject ->
            SubjectCard(
                subject = subject,
                onSubjectClick = { clickedSubject ->
                    // Manejar click en la materia
                    handleSubjectNavigation(clickedSubject)
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}
@Composable
fun SubjectCard(
    subject: Subject,
    onSubjectClick: (Subject) -> Unit = {}
) {
    BaseCard(
        onClick = { onSubjectClick(subject) }
    ) {
        SubjectIcon(
            iconRes = subject.iconRes,
            color = subject.color,
            contentDescription = "Icono de ${subject.name}"
        )

        Spacer(modifier = Modifier.width(20.dp))

        SubjectInfo(
            name = subject.name,
            description = subject.description,
            modifier = Modifier.weight(1f)
        )

        ActionButton(
            onClick = { onSubjectClick(subject) }
        )
    }
}

@Composable
 fun SubjectIcon(
    iconRes: Int,
    color: Color,
    contentDescription: String
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(color.copy(alpha = 0.1f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun SubjectInfo(
    name: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            name,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF003366)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            description,
            fontSize = 12.sp,
            color = Color(0xFF0066CC)
        )
    }
}

@Composable
 fun ActionButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
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


