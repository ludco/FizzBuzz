package com.app.fizzbuzz.ui.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.fizzbuzz.model.GameInputs
import com.app.fizzbuzz.ui.GameViewModel
import com.app.fizzbuzz.ui.components.GameForm
import com.app.fizzbuzz.ui.components.Header

@Composable
fun FormScreen(onPlayButtonClicked: (GameInputs) -> Unit, gameViewModel: GameViewModel) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Header()
        GameForm(onPlayButtonClicked, gameViewModel)
    }
}
