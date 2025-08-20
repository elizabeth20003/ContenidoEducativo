package com.elizabeth.contenidoeducativo.android.utils

import com.elizabeth.contenidoeducativo.android.data.Subject

fun handleSubjectNavigation(subject: Subject) {
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