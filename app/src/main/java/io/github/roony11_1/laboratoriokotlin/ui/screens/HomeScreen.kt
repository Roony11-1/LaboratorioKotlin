package io.github.roony11_1.laboratoriokotlin.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Muestra la pantalla principal del laboratorio.
 *
 * @param modifier Modificador para personalizar el diseño de la pantalla.
 */
@Composable
fun HomeScreen(modifier: Modifier = Modifier)
{
    Text(text = "Laboratorio Kotlin", modifier = modifier)
}