package io.github.roony11_1.laboratoriokotlin.ui.models

sealed class ExerciseStatus
{
    data object Pending : ExerciseStatus()
    data object Completed : ExerciseStatus()
}