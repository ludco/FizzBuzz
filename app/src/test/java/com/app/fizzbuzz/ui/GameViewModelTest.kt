package com.app.fizzbuzz.ui

import com.app.fizzbuzz.model.GameInputs
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {
    private val gameViewModel = GameViewModel()

    @Test
    fun result_is_correct_with_given_inputs() {
        val inputs =
            GameInputs(number1 = 3, number2 = 5, word1 = "fizz", word2 = "buzz", limit = 20)
        var currentGameUiState = gameViewModel.uiState.value
        gameViewModel.getResult(inputs)
        currentGameUiState = gameViewModel.uiState.value
        val expectedResult = listOf<String>(
            "1",
            "2",
            "fizz",
            "4",
            "buzz",
            "fizz",
            "7",
            "8",
            "fizz",
            "buzz",
            "11",
            "fizz",
            "13",
            "14",
            "fizzbuzz",
            "16",
            "17",
            "fizz",
            "19",
            "buzz"
        )
        Assert.assertEquals(expectedResult, currentGameUiState.result)
    }

    @Test
    fun reset_game_reinitialize_values() {
        // Run one game round
        val inputs =
            GameInputs(number1 = 3, number2 = 5, word1 = "fizz", word2 = "buzz", limit = 20)
        var currentGameUiState = gameViewModel.uiState.value
        gameViewModel.getResult(inputs)
        // reset game and check values
        gameViewModel.resetGame()
        currentGameUiState = gameViewModel.uiState.value
        val expectedGameState = GameUiState(0, 0, "", "", 0, listOf())
        Assert.assertEquals(expectedGameState, currentGameUiState)
    }
}