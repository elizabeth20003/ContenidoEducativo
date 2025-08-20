package com.elizabeth.contenidoeducativo.android.data

import androidx.compose.ui.graphics.Color

data class Subject(
    val id: String,
    val name: String,
    val iconRes: Int,
    val color: Color,
    val description: String = "Toca para aprender"
)
