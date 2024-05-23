package com.example.jetpack_compose_games

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameMenu(onGameSelected: (Game) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onGameSelected(Game.MEMORY) }) {
            Text("Memory Game")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onGameSelected(Game.TIC_TAC_TOE) }) {
            Text("Tic Tac Toe Game")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onGameSelected(Game.GUESS_THE_NUMBER) }) {
            Text("Guess The Number Game")
        }
    }
}