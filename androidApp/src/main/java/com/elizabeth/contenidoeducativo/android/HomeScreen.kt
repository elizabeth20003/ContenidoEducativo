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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==============================================================================
// MODELO DE DATOS - SEPARADO Y MODULAR
// ==============================================================================

data class Subject(
    val id: String,
    val name: String,
    val iconRes: Int,
    val color: Color,
    val description: String = "Toca para aprender"
)

// ==============================================================================
// REPOSITORIO DE MATERIAS - GESTION MODULAR DE MEMORIA
// ==============================================================================

object SubjectRepository {

    // Lazy initialization - solo se crean cuando se necesitan
    private val mathematicsModule by lazy {
        Subject(
            id = "math",
            name = "Matemáticas",
            iconRes = R.drawable.ic_math,
            color = Color(0xFF007BFF)
        )
    }

    private val spanishModule by lazy {
        Subject(
            id = "spanish",
            name = "Español",
            iconRes = R.drawable.ic_book,
            color = Color(0xFF0066CC)
        )
    }

    private val socialSciencesModule by lazy {
        Subject(
            id = "social",
            name = "Ciencias Sociales",
            iconRes = R.drawable.ic_globe,
            color = Color(0xFF06677F)
        )
    }

    private val naturalSciencesModule by lazy {
        Subject(
            id = "natural",
            name = "Ciencias Naturales",
            iconRes = R.drawable.ic_science,
            color = Color(0xFF4A9EFF)
        )
    }

    private val statisticsModule by lazy {
        Subject(
            id = "statistics",
            name = "Estadística",
            iconRes = R.drawable.ic_chart,
            color = Color(0xFF0080FF)
        )
    }

    private val ethicsModule by lazy {
        Subject(
            id = "ethics",
            name = "Ética",
            iconRes = R.drawable.ic_ethics,
            color = Color(0xFF005BB5)
        )
    }

    // Función para obtener todas las materias disponibles
    fun getAvailableSubjects(): List<Subject> {
        return listOf(
            mathematicsModule,
            spanishModule,
            socialSciencesModule,
            naturalSciencesModule,
            statisticsModule,
            ethicsModule
        )
    }

    // Función para obtener una materia específica por ID
    fun getSubjectById(id: String): Subject? {
        return when (id) {
            "math" -> mathematicsModule
            "spanish" -> spanishModule
            "social" -> socialSciencesModule
            "natural" -> naturalSciencesModule
            "statistics" -> statisticsModule
            "ethics" -> ethicsModule
            else -> null
        }
    }

    // Función para cargar materias de manera dinámica (simula carga desde base de datos)
    fun loadSubjectsAsync(callback: (List<Subject>) -> Unit) {
        // Simula carga asíncrona - en la vida real esto vendría de una API o BD
        callback(getAvailableSubjects())
    }
}

// ==============================================================================
// COMPONENTE PRINCIPAL CON GESTION MODULAR
// ==============================================================================

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
            SubjectGrid(subjects = subjects)
        }

        item {
            Footer()
        }
    }
}

// ==============================================================================
// COMPONENTES REUTILIZABLES
// ==============================================================================

@Composable
fun Header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF003366)),
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
    ) {
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

            Row {
                NavigationButton(
                    text = "Inicio",
                    onClick = { /* Navegar a inicio */ }
                )
                Spacer(modifier = Modifier.width(8.dp))
                NavigationButton(
                    text = "Evaluaciones",
                    onClick = { /* Navegar a evaluaciones */ }
                )
            }
        }
    }
}

@Composable
private fun NavigationButton(
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
fun SubjectGrid(subjects: List<Subject>) {
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
            // Ícono circular
            SubjectIcon(
                iconRes = subject.iconRes,
                color = subject.color,
                contentDescription = "Icono de ${subject.name}"
            )

            Spacer(modifier = Modifier.width(20.dp))

            // Contenido central
            SubjectInfo(
                name = subject.name,
                description = subject.description,
                modifier = Modifier.weight(1f)
            )

            // Botón de acción
            ActionButton(
                onClick = { onSubjectClick(subject) }
            )
        }
    }
}

@Composable
private fun SubjectIcon(
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
private fun SubjectInfo(
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
private fun ActionButton(
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

// ==============================================================================
// FUNCIONES DE UTILIDAD
// ==============================================================================

private fun handleSubjectNavigation(subject: Subject) {
    // Aquí manejarías la navegación a cada materia específica
    when (subject.id) {
        "math" -> {
            // Navegar a módulo de matemáticas
            println("Navegando a Matemáticas")
        }
        "spanish" -> {
            // Navegar a módulo de español
            println("Navegando a Español")
        }
        "social" -> {
            // Navegar a módulo de ciencias sociales
            println("Navegando a Ciencias Sociales")
        }
        "natural" -> {
            // Navegar a módulo de ciencias naturales
            println("Navegando a Ciencias Naturales")
        }
        "statistics" -> {
            // Navegar a módulo de estadística
            println("Navegando a Estadística")
        }
        "ethics" -> {
            // Navegar a módulo de ética
            println("Navegando a Ética")
        }
    }
}