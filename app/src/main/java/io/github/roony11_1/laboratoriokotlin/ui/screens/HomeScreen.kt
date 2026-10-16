package io.github.roony11_1.laboratoriokotlin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.roony11_1.laboratoriokotlin.ui.models.ExerciseStatus

private data class Exercise(
    val id: Int,
    val title: String,
    val description: String,
    val status: ExerciseStatus = ExerciseStatus.Pending)

private val sampleExercises = listOf(
    Exercise(1, "Compose básico", "Composición y layouts"),
    Exercise(2, "Estado", "Actualizar la interfaz"),
    Exercise(3, "Listas", "Mostrar colecciones"))

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier)
{
    /**
     * Lista que vive en el componente, es la "verdad" que se muestra en pantalla.
     * Android renderiza automaticamente al evidenciar cambios en esta
     */
    val exercises = remember {
        mutableStateListOf<Exercise>().apply {
            addAll(sampleExercises)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp))
        {
            Header(
                completedCount = exercises.count {
                    it.status is ExerciseStatus.Completed
                },
                totalCount = exercises.size)

            ExerciseList(
                exercises = exercises,
                onComplete = { exerciseId ->
                    // Obtenemos el objeto con la referencia de id
                    val exercise = exercises.find { it.id == exerciseId }

                    if (exercise != null)
                    {
                        val index = exercises.indexOf(exercise)

                        // Mutamos la lista con el objeto cambiandolo a completado
                        exercises[index] = exercise.copy(status = ExerciseStatus.Completed)
                    }
                })
        }
    }
}

@Composable
private fun Header(
    completedCount: Int,
    totalCount: Int)
{
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        Text(
            text = "Laboratorio Kotlin",
            style = MaterialTheme.typography.headlineMedium)

        Text(
            text = "Progreso: $completedCount de $totalCount ejercicios")
    }
}

/**
 * Componente que se encarga de renderizar los ejercicios
 */
@Composable
private fun ExerciseList(
    exercises: List<Exercise>,
    onComplete: (Int) -> Unit)
{
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp))
    {
        items(
            items = exercises,
            key = { exercise -> exercise.id }) { exercise ->
            ExerciseCard(
                exercise = exercise,
                onComplete = {
                    onComplete(exercise.id)
                })
        }
    }
}

/**
 * Cada carta de la lista que maneja su propia lógica
 */
@Composable
private fun ExerciseCard(
    exercise: Exercise,
    onComplete: () -> Unit)
{
    Card(
        modifier = Modifier.fillMaxWidth())
    {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp))
        {
            Text(
                text = exercise.title,
                style = MaterialTheme.typography.titleMedium)

            Text(text = exercise.description)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                // Mostrar un texto según el tipo de ExerciseStatus.
                Text(text = "Estado: ${exercise.status}")

                // Mostrar un botón solo cuando el ejercicio esté pendiente.
                // Al pulsarlo, invocar onComplete.

                // Renderización condicional
                if (exercise.status == ExerciseStatus.Pending)
                    Button(onClick = onComplete)
                    {
                        Text(text = "Completar")
                    }
            }
        }
    }
}