package com.example.jetpack_compose_games

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.jetpack_compose_games.ui.theme.JetpackComposeGamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeGamesTheme {
                var selectedGame by remember { mutableStateOf<Game?>(null) }

                when (selectedGame) {
                    Game.MEMORY -> MemoryGame()
                    Game.TIC_TAC_TOE -> TicTacToeGame()
                    Game.GUESS_THE_NUMBER -> GuessTheNumberGame()
                    null -> GameMenu(onGameSelected = { selectedGame = it })
                }
            }
        }
    }
}



enum class Game {
    MEMORY, TIC_TAC_TOE, GUESS_THE_NUMBER
}