package com.app.fizzbuzz.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.app.fizzbuzz.model.GameInputs
import com.app.fizzbuzz.ui.GameViewModel
import com.app.fizzbuzz.ui.components.GameForm
import com.app.fizzbuzz.ui.components.Header

@Composable
fun FormScreen(onPlayButtonClicked: (GameInputs)->Unit, gameViewModel: GameViewModel) {
    Column {
        Header()
        GameForm(onPlayButtonClicked, gameViewModel)
    }
}
