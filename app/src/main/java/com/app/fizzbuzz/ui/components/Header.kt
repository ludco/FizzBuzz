package com.app.fizzbuzz.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Header(){
    Column(modifier = Modifier.fillMaxWidth().padding(vertical =15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "The FizzBuzz Game", style= MaterialTheme.typography.h4)
    }
}