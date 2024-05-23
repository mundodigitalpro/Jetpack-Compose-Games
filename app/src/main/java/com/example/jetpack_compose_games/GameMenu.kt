/*
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
}*/
/*

package com.example.jetpack_compose_games

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameMenu(onGameSelected: (Game) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Choose a Game", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))
        GameOptionCard(
            title = "Memory Game",
            imageRes = R.drawable.memory_game_image,  // Asegúrate de agregar la imagen en res/drawable
            onClick = { onGameSelected(Game.MEMORY) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        GameOptionCard(
            title = "Tic Tac Toe",
            imageRes = R.drawable.tic_tac_toe_image,  // Asegúrate de agregar la imagen en res/drawable
            onClick = { onGameSelected(Game.TIC_TAC_TOE) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        GameOptionCard(
            title = "Guess The Number",
            imageRes = R.drawable.guess_the_number_image,  // Asegúrate de agregar la imagen en res/drawable
            onClick = { onGameSelected(Game.GUESS_THE_NUMBER) }
        )
    }
}

@Composable
fun GameOptionCard(title: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),  // Usar CardDefaults.cardElevation
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, style = MaterialTheme.typography.headlineMedium, fontSize = 20.sp)
        }
    }
}

*/


package com.example.jetpack_compose_games

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameMenu(onGameSelected: (Game) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Choose a Game", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))
        GameOptionCard(
            title = "Memory Game",
            imageRes = R.drawable.memory_game_image,
            onClick = { onGameSelected(Game.MEMORY) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        GameOptionCard(
            title = "Tic Tac Toe",
            imageRes = R.drawable.tic_tac_toe_image,
            onClick = { onGameSelected(Game.TIC_TAC_TOE) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        GameOptionCard(
            title = "Guess The Number",
            imageRes = R.drawable.guess_the_number_image,
            onClick = { onGameSelected(Game.GUESS_THE_NUMBER) }
        )
    }
}

@Composable
fun GameOptionCard(title: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)  // Ajustar la altura de la tarjeta
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)  // Ajustar el tamaño de la imagen
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(title, style = MaterialTheme.typography.headlineMedium, fontSize = 20.sp)
        }
    }
}
