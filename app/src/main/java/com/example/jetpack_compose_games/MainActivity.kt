package com.example.jetpack_compose_games

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpack_compose_games.ui.theme.JetpackComposeGamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeGamesTheme {
            MemoryGame()
            //TicTacToeGame()
            //GuessTheNumberGame()

            }
        }
    }
}
