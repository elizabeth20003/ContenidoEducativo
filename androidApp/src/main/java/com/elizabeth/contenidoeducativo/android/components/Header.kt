package com.elizabeth.contenidoeducativo.android.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elizabeth.contenidoeducativo.android.NavigationButton


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