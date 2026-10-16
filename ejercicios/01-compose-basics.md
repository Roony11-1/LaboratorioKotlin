# Ejercicio 01 — Laboratorio de ejercicios

## Contexto

El laboratorio necesita una pantalla principal que muestre una colección de ejercicios, su estado actual y el progreso general del usuario.

La interfaz ya cuenta con componentes separados y un modelo que representa cada ejercicio. Sin embargo, faltan algunas implementaciones para que el estado se actualice correctamente.

## Objetivos

- Comprender la composición de interfaces con Jetpack Compose.
- Reconocer la diferencia entre estado y eventos.
- Representar estados mediante una `sealed class`.
- Actualizar colecciones de forma inmutable.
- Comprender el flujo de datos entre componentes padre e hijo.

## Requisitos funcionales

1. Mostrar el título del laboratorio y el progreso general.
2. Presentar los ejercicios en una lista desplazable.
3. Mostrar el estado correspondiente en cada tarjeta.
4. Permitir completar un ejercicio pendiente.
5. Evitar que un ejercicio completado vuelva a completarse mediante la misma acción.
6. Actualizar el progreso automáticamente después de completar un ejercicio.
7. Mantener el estado de cada ejercicio independiente del estado de los demás.

## Requisitos técnicos

- Utilizar Kotlin, Jetpack Compose y Material 3.
- Representar el estado de un ejercicio mediante una `sealed class`.
- Mantener el estado de la pantalla en el componente principal.
- Comunicar las acciones de los componentes hijos mediante callbacks.
- No modificar directamente una colección existente.
- Mantener las responsabilidades de los componentes actuales.

## Restricciones

- No utilizar ViewModel todavía.
- No incorporar Room, SQLite ni persistencia.
- No añadir nuevas dependencias.
- No introducir capas `domain` o `application` en este ejercicio.
- No resolver toda la interfaz dentro de un único composable.

## Pistas

- ¿Qué ventajas tiene representar los estados con tipos diferentes en lugar de un `Boolean`?
- ¿Cómo puedes comprobar el tipo de estado de una instancia?
- ¿Cómo puedes actualizar un solo elemento de una lista sin modificar la lista original?
- ¿Por qué el componente de la tarjeta debería recibir un callback en lugar de modificar directamente el estado de la pantalla?
- ¿Qué información necesita el encabezado para calcular el progreso?

## Criterios de aceptación

- [ ] La pantalla muestra todos los ejercicios.
- [ ] Cada estado se representa correctamente.
- [ ] Solo los ejercicios pendientes pueden completarse.
- [ ] Completar un ejercicio no modifica los demás.
- [ ] El contador de progreso se actualiza automáticamente.
- [ ] La solución mantiene la separación entre componentes.
- [ ] El proyecto compila y se ejecuta correctamente.