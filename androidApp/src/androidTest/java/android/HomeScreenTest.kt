package android


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import com.elizabeth.contenidoeducativo.android.HomeScreen
import com.elizabeth.contenidoeducativo.android.R
import com.elizabeth.contenidoeducativo.android.SubjectCard
import com.elizabeth.contenidoeducativo.android.data.Subject
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
//Que un texto específico aparece en la UI
    @Test
    fun homeScreen_displaysTitle() {
        // Renderizamos la pantalla en el test
        composeTestRule.setContent {
            HomeScreen()
        }

        // Verificamos que el título principal esté en pantalla
        composeTestRule
            .onNodeWithText("CONTENIDO EDUCATIVO")
            .assertIsDisplayed()
    }
//Que un elemento de UI es interactuable
    @Test
    fun subjectCard_clicksOnEnterButton() {
        // Renderizamos un SubjectCard simple
        composeTestRule.setContent {
            SubjectCard(
                subject = Subject(
                    id = "math",
                    name = "Matemáticas",
                    description = "Toca para aprender",
                    iconRes = R.drawable.ic_math,
                    color = Color(0xFF007BFF)
                ),

            )
        }

        // Buscamos el botón "Entrar" y hacemos click
        composeTestRule
            .onNodeWithText("Entrar")
            .performClick()
    }
}

