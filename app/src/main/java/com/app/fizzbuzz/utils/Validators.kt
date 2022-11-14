package com.app.fizzbuzz.utils

import com.app.fizzbuzz.model.InputError

fun checkNumberValidation(input: String): InputError {
    try {
        when {
            input.isEmpty() -> return InputError("Number is required", true)
            input.toInt() == 0 -> return InputError("Number cannot be zero", true)
            else -> return InputError("", false)
        }
    } catch (e: java.lang.NumberFormatException) {
        return InputError("A valid number is required", true)
    }
}

fun checkWordValidation(input: String): InputError {
    when {
        input.isEmpty() -> return InputError("Word is required", true)
        else -> return InputError("", false)
    }
}