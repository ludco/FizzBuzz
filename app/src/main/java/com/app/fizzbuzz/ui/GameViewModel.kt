package com.app.fizzbuzz.ui

import androidx.lifecycle.ViewModel
import com.app.fizzbuzz.model.GameInputs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    /*
    Get result list of items, with given game inputs, update game state
     */
    fun getResult(gameInputs: GameInputs) {
        var list = mutableListOf<String>()
        for (i in 1..gameInputs.limit) {
            when {
                (i % gameInputs.number1 == 0 && i % gameInputs.number2 != 0) -> list.add(gameInputs.word1)
                (i % gameInputs.number2 == 0 && i % gameInputs.number1 != 0) -> list.add(gameInputs.word2)
                (i % gameInputs.number1 == 0 && i % gameInputs.number2 == 0) -> list.add(gameInputs.word1 + gameInputs.word2)
                else -> list.add(i.toString())
            }
        }
        _uiState.update { currentState ->
            currentState.copy(
                result = list,
            )
        }
    }

    /*
    Set game state to initial values
     */
    fun resetGame() {
        _uiState.update { currentState ->
            currentState.copy(
                number1 = 0,
                number2 = 0,
                word1 = "",
                word2 = "",
                limit = 0,
                result = listOf()
            )
        }
    }
}