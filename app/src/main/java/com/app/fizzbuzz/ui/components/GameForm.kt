package com.app.fizzbuzz.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.app.fizzbuzz.R
import com.app.fizzbuzz.model.GameInputs
import com.app.fizzbuzz.ui.GameViewModel
import com.app.fizzbuzz.utils.checkNumberValidation
import com.app.fizzbuzz.utils.checkWordValidation


@Composable
fun GameForm(
    onPlayButtonClicked: (GameInputs) -> Unit,
    gameViewModel: GameViewModel,
) {

    val focusManager = LocalFocusManager.current
    var number1 by remember { mutableStateOf("") }
    var number1Error by remember { mutableStateOf(false) }
    var number2 by remember { mutableStateOf("") }
    var number2Error by remember { mutableStateOf(false) }
    var word1 by remember { mutableStateOf("") }
    var word1Error by remember { mutableStateOf(false) }
    var word2 by remember { mutableStateOf("") }
    var word2Error by remember { mutableStateOf(false) }
    var sliderPosition by remember { mutableStateOf(1f) }


    fun onSubmit() {
        val gameInputs = GameInputs(
            number1 = number1.toInt(),
            number2 = number2.toInt(),
            word1 = word1,
            word2 = word2,
            limit = sliderPosition.toInt()
        )
        onPlayButtonClicked(gameInputs)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp), verticalArrangement = Arrangement.Center
    ) {

        // --------- Numbers Part ----------
        Text(text = stringResource(R.string.enter_numbers))
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
        ) {
            InputField(
                value = number1,
                onValueChange = {
                    number1 = it; number1Error = checkNumberValidation(it).error
                },
                label = R.string.number_1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
                modifier = Modifier
                    .weight(0.5f)
                    .padding(15.dp),
                isError = number1Error,
                errorMsg = checkNumberValidation(number1).message
            )

            InputField(
                value = number2,
                onValueChange = { number2 = it; number2Error = checkNumberValidation(it).error },
                label = R.string.number_2,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                }),
                modifier = Modifier
                    .weight(0.5f)
                    .padding(15.dp),
                isError = number2Error,
                errorMsg = checkNumberValidation(number2).message
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // --------- Words Part ----------
        Text(text = stringResource(R.string.enter_words))
        Row(
            Modifier
                .height(IntrinsicSize.Max)
        ) {
            InputField(
                value = word1,
                onValueChange = { word1 = it; word1Error = checkWordValidation(word1).error },
                label = R.string.word_1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
                modifier = Modifier
                    .weight(1f)
                    .padding(15.dp),
                isError = word1Error,
                errorMsg = checkWordValidation(word1).message
            )
            InputField(
                value = word2,
                onValueChange = { word2 = it; word2Error = checkWordValidation(word2).error },
                label = R.string.word_2,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                modifier = Modifier
                    .weight(1f)
                    .padding(15.dp),
                isError = word2Error,
                errorMsg = checkWordValidation(word2).message
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // --------- Limit Part ----------
        Text(text = stringResource(R.string.choose_limit))
        Row(modifier = Modifier.padding(15.dp)) {
            LimitSlider(value = sliderPosition, onValueChange = { sliderPosition = it })
        }


        // --------- Submit button Part ----------
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = { onSubmit() },
                enabled = number1.isNotEmpty() && !number1Error && number2.isNotEmpty() && !number2Error && word1.isNotEmpty() &&
                        !word1Error && word2.isNotEmpty() && !word2Error
            ) {
                Text(text = stringResource(R.string.play))
            }
        }


    }
}