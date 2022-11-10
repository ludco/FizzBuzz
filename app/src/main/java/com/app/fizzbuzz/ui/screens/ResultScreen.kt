package com.app.fizzbuzz.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.fizzbuzz.R
import com.app.fizzbuzz.ui.GameUiState

@Composable
fun ResultScreen(gameUiState: GameUiState, onPlayAgainButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row() {
            Text(text = stringResource(R.string.result_is), style = MaterialTheme.typography.h4)
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth().fillMaxHeight(0.8f)
                .clip(RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colors.primary)
        ) {
            items(gameUiState.result) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${item}, ", textAlign = TextAlign.Center, color = Color.White)
                }

            }
        }
        Spacer(Modifier.weight(0.1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = onPlayAgainButtonClicked) {
                Text(stringResource(R.string.play_again))
            }
        }
    }
}