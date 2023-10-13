package com.example.hangmangame

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CURRENT_WORDTOGUESS_KEY = "CURRENT_WORDTOGUESS_KEY"
const val CURRENT_LETTERSUSED_KEY = "CURRENT_LETTERSUSED_KEY"
const val CURRENT_USEDLETTER_KEY = "CURRENT_USEDLETTER_KEY"
const val CURRENT_REVEALEDLETTER_KEY = "CURRENT_REVEALED_KEY"

class viewModelState (private val savedStateHandle: SavedStateHandle):ViewModel()
{    var wordToGuess: String
        get() = savedStateHandle.get(CURRENT_WORDTOGUESS_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_WORDTOGUESS_KEY, value)

     var lettersUsed: String
        get() = savedStateHandle.get(CURRENT_LETTERSUSED_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_LETTERSUSED_KEY, value)
    var usedLetter: MutableList<Char>
        get() = savedStateHandle.get<MutableList<Char>>(CURRENT_USEDLETTER_KEY) ?: mutableListOf()
        set(value) {
            savedStateHandle.set(CURRENT_USEDLETTER_KEY, value)
        }

    var revealedLetter: MutableList<Char>
        get() = savedStateHandle.get<MutableList<Char>>(CURRENT_USEDLETTER_KEY) ?: mutableListOf()
        set(value) {
            savedStateHandle.set(CURRENT_USEDLETTER_KEY, value)
        }

}