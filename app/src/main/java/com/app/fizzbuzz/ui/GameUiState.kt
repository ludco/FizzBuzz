package com.app.fizzbuzz.ui

data class GameUiState(
    val number1 : Int = 0,
    val number2 : Int = 0,
    val word1: String = "",
    val word2 : String="",
    val limit : Int = 0,
    val result : List<String> = listOf()
)