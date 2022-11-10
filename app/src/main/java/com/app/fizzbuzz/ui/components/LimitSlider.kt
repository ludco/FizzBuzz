package com.app.fizzbuzz.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LimitSlider(value: Float, onValueChange: (Float) -> Unit) {
    Column() {
        Text(text = value.toInt().toString())
        Slider(value = value, onValueChange = onValueChange, valueRange = 0f..100f)
    }
}