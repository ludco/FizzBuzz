package com.app.fizzbuzz.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.fizzbuzz.ui.components.GameForm
import com.app.fizzbuzz.ui.components.Header
import com.app.fizzbuzz.ui.theme.FizzBuzzTheme

@Composable
fun FormScreen() {
    Column {
        Header()
        GameForm()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FizzBuzzTheme {
        FormScreen()
    }
}