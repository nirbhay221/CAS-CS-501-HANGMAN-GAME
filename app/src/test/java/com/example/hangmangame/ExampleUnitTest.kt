package com.example.hangmangame

import androidx.lifecycle.SavedStateHandle
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    private lateinit var viewModel: viewModelState

    @Before
    fun setup() {
        val savedStateHandle = SavedStateHandle()
        viewModel = viewModelState(savedStateHandle)
    }

    @Test
    fun testGameStart() {
        viewModel.startNewGame()
        assertEquals("apple", viewModel.wordToGuess)
        assertFalse(viewModel.winningCondition)
        assertEquals("_____", viewModel.underscoreWords)
        assertEquals(5, viewModel.Turns)
    }

    @Test
    fun testLetterSelectionWithIncorrectLetter() {

        viewModel.ButtonVisibility = true

        viewModel.wordToGuess = "apple"
        viewModel.generateBlankSets(viewModel.wordToGuess)

        viewModel.usedLetter.add('x')
        viewModel.Turns--
        viewModel.ButtonVisibility = false

        assertFalse(viewModel.ButtonVisibility)
    }

}
