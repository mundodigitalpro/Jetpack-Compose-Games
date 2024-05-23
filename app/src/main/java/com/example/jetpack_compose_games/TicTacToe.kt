package com.example.jetpack_compose_games
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TicTacToeGame() {
    var currentPlayer by remember { mutableStateOf("X") }
    var board by remember { mutableStateOf(List(3) { mutableStateListOf("", "", "") }) }
    var winner by remember { mutableStateOf<String?>(null) }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Tic Tac Toe") })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Turno del jugador: $currentPlayer",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Draw the board
            for (i in 0..2) {
                Row {
                    for (j in 0..2) {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .border(2.dp, Color.Black)
                                .background(if (board[i][j] == "") Color.LightGray else if (board[i][j] == "X") Color.Red else Color.Blue)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = {
                                    if (board[i][j] == "" && winner == null) {
                                        board[i][j] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O" else "X"
                                        winner = checkWinner(board)
                                    }
                                },
                                modifier = Modifier.fillMaxSize(),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                            ) {
                                Text(board[i][j], fontSize = 32.sp, color = Color.White)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (winner != null) {
                Text("El ganador es: $winner", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Button(onClick = {
                    // Reset the game
                    board = List(3) { mutableStateListOf("", "", "") }
                    currentPlayer = "X"
                    winner = null
                }) {
                    Text("Reiniciar Juego")
                }
            }
        }
    }
}

fun checkWinner(board: List<List<String>>): String? {
    // Check rows
    for (i in 0..2) {
        if (board[i][0] != "" && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return board[i][0]
        }
    }

    // Check columns
    for (j in 0..2) {
        if (board[0][j] != "" && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
            return board[0][j]
        }
    }

    // Check diagonals
    if (board[0][0] != "" && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
        return board[0][0]
    }
    if (board[0][2] != "" && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
        return board[0][2]
    }

    // Check for a draw
    var emptyCount = 0
    for (i in 0..2) {
        for (j in 0..2) {
            if (board[i][j] == "") {
                emptyCount++
            }
        }
    }
    if (emptyCount == 0) return "Draw"

    return null
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TicTacToeGame()
}