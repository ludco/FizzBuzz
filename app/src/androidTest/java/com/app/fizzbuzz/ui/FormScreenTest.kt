package com.app.fizzbuzz.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.app.fizzbuzz.ui.screens.FormScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FormScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setupFormScreen() {
        composeTestRule.setContent {
            FormScreen(onPlayButtonClicked = {}, gameViewModel = GameViewModel())
        }
    }

    @Test
    fun formScreen_fillFieldsWithCorrectInputs_PlayButtonIsEnabled() {
        composeTestRule.onNodeWithText("Number 1").performTextInput("3")
        composeTestRule.onNodeWithText("Number 2").performTextInput("5")
        composeTestRule.onNodeWithText("Word 1").performTextInput("fizz")
        composeTestRule.onNodeWithText("Word 2").performTextInput("buzz")
        val button = composeTestRule.onNodeWithText("Play !")
        button.assertIsEnabled()
    }

    @Test
    fun formScreen_fillFieldsWithOneErrorInputs_PlayButtonIsNotEnabled() {
        composeTestRule.onNodeWithText("Number 1").performTextInput("0")
        composeTestRule.onNodeWithText("Number 2").performTextInput("5")
        composeTestRule.onNodeWithText("Word 1").performTextInput("fizz")
        composeTestRule.onNodeWithText("Word 2").performTextInput("buzz")
        val button = composeTestRule.onNodeWithText("Play !")
        button.assertIsNotEnabled()
    }

    @Test
    fun formScreen_fillFieldsWithOneErrorInputs_ErrorMessageIsDisplayed() {
        composeTestRule.onNodeWithText("Number 1").performTextInput("0")
        val errorMessage = composeTestRule.onNodeWithText("Number cannot be zero")
        errorMessage.assertIsDisplayed()

    }
}