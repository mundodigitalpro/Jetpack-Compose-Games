package com.example.jetpack_compose_games

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


@Composable
fun GuessTheNumberGame(onBack: () -> Unit) {
    var guess by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("Adivina el número entre 1 y 100") }
    val targetNumber = remember { Random.nextInt(1, 101) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        OutlinedTextField(
            value = guess,
            onValueChange = { guess = it },
            label = { Text("Tu número") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                val userGuess = guess.toIntOrNull()
                if (userGuess == null) {
                    message = "Por favor, introduce un número"
                } else {
                    if (userGuess < targetNumber) {
                        message = "Más alto!"
                    } else if (userGuess > targetNumber) {
                        message = "Más bajo!"
                    } else {
                        message = "¡Correcto! El número era $targetNumber"
                    }
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Adivinar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onBack,
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Volver al Menú Principal")
        }
    }
}
