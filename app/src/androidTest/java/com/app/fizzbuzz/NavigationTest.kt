package com.app.fizzbuzz


import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.app.fizzbuzz.ui.AppScreens
import com.app.fizzbuzz.ui.FizzBuzzApp
import com.app.fizzbuzz.ui.FormScreenTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            FizzBuzzApp(navController = navController)
        }
    }

    @Test
    fun navHost_verifyStartDestination(){
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, AppScreens.Form.name)
    }


    @Test
    fun navHost_clickOnPlay_navigateToResultScreen(){
        composeTestRule.onNodeWithText("Number 1").performTextInput("3")
        composeTestRule.onNodeWithText("Number 2").performTextInput("5")
        composeTestRule.onNodeWithText("Word 1").performTextInput("fizz")
        composeTestRule.onNodeWithText("Word 2").performTextInput("buzz")
        composeTestRule.onNodeWithText("Play !")
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, AppScreens.Result.name)
    }

    @Test
    fun navHost_clickOnPlayAgain_navigateToFormScreen(){
        navHost_clickOnPlay_navigateToResultScreen()
        composeTestRule.onNodeWithText("Play again !")
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, AppScreens.Form.name)
    }
}
