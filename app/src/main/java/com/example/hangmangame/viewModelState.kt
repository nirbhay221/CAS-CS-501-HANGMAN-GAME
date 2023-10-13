package com.example.hangmangame

import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random

const val CURRENT_WORDTOGUESS_KEY = "CURRENT_WORDTOGUESS_KEY"
const val CURRENT_LETTERSUSED_KEY = "CURRENT_LETTERSUSED_KEY"
const val CURRENT_USEDLETTER_KEY = "CURRENT_USEDLETTER_KEY"
const val CURRENT_REVEALEDLETTER_KEY = "CURRENT_REVEALEDLETTER_KEY"
const val CURRENT_UNDERSCORE_WORDS_KEY = "CURRENT_UNDERSCORE_WORDS_KEY"
const val CURRENT_PRESENTATIONSTRING_KEY = "CURRENT_PRESENTATIONSTRING_KEY"
const val CURRENT_WINORLOSE_KEY = "CURRENT_WINORLOSE_KEY"
const val CURRENT_BUTTONSVISIBLE_KEY = "CURRENT_BUTTONSVISIBLE_KEY"
const val CURRENT_WORDSUSED_KEY = "CURRENT_WORDSUSED_KEY"
const val CURRENT_UPDATEDWORDS_KEY = "CURRENT_UPDATEDWORDS_KEY"
const val CURRENT_TRIES_KEY = "CURRENT_TRIES_KEY"
const val CURRENT_HINTTEXT_KEY = "CURRENT_HINTTEXT_KEY"
const val CURRENT_HINTTRIES_KEY = "CURRENT_HINTTRIES_KEY"

const val CURRENT_DISABLEWORDS_KEY = "CURRENT_DISABLEWORDS_KEY"
const val CURRENT_TURN_KEY = "CURRENT_TURN_KEY"

class viewModelState (private val savedStateHandle: SavedStateHandle):ViewModel() {
    var wordToGuess: String
        get() = savedStateHandle.get(CURRENT_WORDTOGUESS_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_WORDTOGUESS_KEY, value)

    var winningCondition: Boolean
        get() = savedStateHandle.get(CURRENT_WINORLOSE_KEY) ?: false
        set(value) = savedStateHandle.set(CURRENT_WINORLOSE_KEY, value)

    var ButtonVisibility: Boolean
        get() = savedStateHandle.get(CURRENT_BUTTONSVISIBLE_KEY) ?: false
        set(value) = savedStateHandle.set(CURRENT_BUTTONSVISIBLE_KEY, value)
     var lettersUsed: String
        get() = savedStateHandle.get(CURRENT_LETTERSUSED_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_LETTERSUSED_KEY, value)

    var underscoreWords: String
        get() = savedStateHandle.get(CURRENT_UNDERSCORE_WORDS_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_UNDERSCORE_WORDS_KEY, value)

    var disableWords: String
        get() = savedStateHandle.get(CURRENT_DISABLEWORDS_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_DISABLEWORDS_KEY, value)

    var wordsUsed: String
        get() = savedStateHandle.get(CURRENT_WORDSUSED_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_WORDSUSED_KEY, value)

    var usedLetter = mutableListOf<Char>()
    var revealedLetter = mutableListOf<Char>()


    var presentationString: String
        get() = savedStateHandle.get(CURRENT_PRESENTATIONSTRING_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_PRESENTATIONSTRING_KEY, value)

    var currentTries: Int
        get() = savedStateHandle.get(CURRENT_TRIES_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_TRIES_KEY, value)
    var Turns: Int
        get() = savedStateHandle.get(CURRENT_TURN_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_TURN_KEY, value)



    var hintTries: Int
        get() = savedStateHandle.get(CURRENT_HINTTRIES_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_HINTTRIES_KEY, value)

    var hintText: String
        get() = savedStateHandle.get(CURRENT_HINTTEXT_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_HINTTEXT_KEY, value)

    var updatedWord: String
        get() = savedStateHandle.get(CURRENT_UPDATEDWORDS_KEY) ?: ""
        set(value) = savedStateHandle.set(CURRENT_UPDATEDWORDS_KEY, value)

    val wordCategoriesMap = mapOf(

        "apple" to "Fruit",
    )
    fun generateBlankSets(word: String){
        val blankRepresentation = StringBuilder()
        for(char in word){
            if(char.isLetterOrDigit()){
                blankRepresentation.append("_")
            }
            else if(char == '/'){
                blankRepresentation.append('/')
            }
            else{
                blankRepresentation.append(char)
            }
        }
        presentationString = blankRepresentation.toString()
        underscoreWords = presentationString

    }

    fun winOrLos(){

        if(usedLetter.size == wordToGuess.length){
            var underscoreTextString = underscoreWords

            var cleanedUnderscoreText = underscoreTextString.replace(" ", "").replace(",", "")

            winningCondition = checkGameConditions(cleanedUnderscoreText)

        }
        else if (!underscoreWords.contains('_')) {
            var underscoreTextString = underscoreWords

            var cleanedUnderscoreText = underscoreTextString.replace(" ", "").replace(",", "")

            winningCondition = checkGameConditions(cleanedUnderscoreText)
        }
        else{
        }

    }
    fun modifyUnderscoreWord(){

        updatedWord =""
        for (i in wordToGuess.indices) {
            if (revealedLetter.contains(wordToGuess[i])) {
                updatedWord += wordToGuess[i]
            } else {
                updatedWord += '_'
            }

            if (i < wordToGuess.length - 1) {
                updatedWord +=' '
            }
        }
        underscoreWords = updatedWord
    }

    fun startNewGame(){
        usedLetter.clear()
        revealedLetter.clear()
        val randomIndex = Random.nextInt(0,wordCategoriesMap.size)
        val valueList = wordCategoriesMap.keys.toList()
        wordToGuess = valueList[randomIndex]
        generateBlankSets(wordToGuess)
        generateLettersUsed(usedLetter)
        disableWords = ""
        currentTries = 0
        Turns = wordToGuess.length
    }
    fun generateLettersUsed(usedLetter:List<Char>){
        var lettersUsedString = StringBuilder()
        if(usedLetter.isEmpty()){
            wordsUsed = "No Letters used yet."

        }else {
            lettersUsedString.append("Letters used: ")
            for (letter in usedLetter) {
                lettersUsedString.append(letter)
                lettersUsedString.append(' ')
            }
            wordsUsed = lettersUsedString.toString()
        }
    }

    fun checkGameConditions(cleanedUnderscoreText:String):Boolean{


        return cleanedUnderscoreText== wordToGuess


    }


}