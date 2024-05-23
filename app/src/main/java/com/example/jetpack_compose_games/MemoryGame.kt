package com.example.jetpack_compose_games

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MemoryGame() {
    val colors = listOf(
        Color.Red, Color.Green, Color.Blue, Color.Magenta, Color.Cyan,
        Color.Yellow, Color.Gray, Color.LightGray, Color.DarkGray, Color.Black
    )
    val gridSize = 4
    val gameColors = remember {
        val allColors = List(gridSize * gridSize / 2) { colors[it % colors.size] }
        (allColors + allColors).shuffled(Random(System.currentTimeMillis()))
    }

    val revealed = remember { mutableStateListOf<Int>() }
    val matched = remember { mutableStateListOf<Boolean>() }
    var moves by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    // Initialize the matched list
    LaunchedEffect(Unit) {
        if (matched.isEmpty()) {
            matched.addAll(List(gridSize * gridSize) { false })
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Moves: $moves", style = MaterialTheme.typography.labelLarge)

        Spacer(modifier = Modifier.height(16.dp))

        for (i in 0 until gridSize) {
            Row {
                for (j in 0 until gridSize) {
                    val index = i * gridSize + j
                    MemoryCard(
                        color = if (matched.getOrNull(index) == true || revealed.contains(index)) gameColors[index] else Color.LightGray,
                        onClick = {
                            if (revealed.size < 2 && matched.getOrNull(index) == false && !revealed.contains(index)) {
                                revealed.add(index)
                                if (revealed.size == 2) {
                                    moves++
                                    if (gameColors[revealed[0]] == gameColors[revealed[1]]) {
                                        matched[revealed[0]] = true
                                        matched[revealed[1]] = true
                                    }
                                    coroutineScope.launch {
                                        delay(500)
                                        revealed.clear()
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }

    if (matched.all { it }) {
        Spacer(modifier = Modifier.height(32.dp)) // Add space between the board and the congratulations message
        Text(
            text = "Congratulations! You won in $moves moves!",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}


@Composable
fun MemoryCard(color: Color, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(60.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            // Empty Box to maintain the structure
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MemoryGamePreview() {
    MemoryGame()
}