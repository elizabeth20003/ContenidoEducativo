package com.elizabeth.contenidoeducativo.android.data

import androidx.compose.ui.graphics.Color
import com.elizabeth.contenidoeducativo.android.R
import com.elizabeth.contenidoeducativo.android.data.SubjectRepository.getAvailableSubjects


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
}

// Función para cargar materias de manera dinámica (simula carga desde base de datos)
fun loadSubjectsAsync(callback: (List<Subject>) -> Unit) {
    // Simula carga asíncrona - en la vida real esto vendría de una API o BD
    callback(getAvailableSubjects())
}



