package com.example.hangmangame

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import kotlin.random.Random
import kotlin.text.StringBuilder

class MainActivity2 : AppCompatActivity() {

    private val viewModel by viewModels<viewModelState>()
    private val maxTries = 3
    private lateinit var blankWords:String

    private lateinit var keyA: Button
    private lateinit var keyB: Button
    private lateinit var keyC: Button
    private lateinit var keyD: Button
    private lateinit var keyE: Button
    private lateinit var keyF: Button
    private lateinit var keyG: Button
    private lateinit var keyH: Button
    private lateinit var keyI: Button
    private lateinit var keyJ: Button
    private lateinit var keyK: Button
    private lateinit var keyL: Button
    private lateinit var keyM: Button
    private lateinit var keyN: Button
    private lateinit var keyO: Button
    private lateinit var keyP: Button
    private lateinit var keyQ: Button
    private lateinit var keyR: Button
    private lateinit var keyS: Button
    private lateinit var keyT: Button
    private lateinit var keyU: Button
    private lateinit var keyV: Button
    private lateinit var keyW: Button
    private lateinit var keyX: Button
    private lateinit var keyY: Button
    private lateinit var keyZ: Button
    private lateinit var underscoreWords: TextView
    private lateinit var wordsUsed : TextView
    private lateinit var startGame : Button
    private var hintButton : Button ?= null
    private var hintResult : TextView ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main2_landscape)
        } else {
            setContentView(R.layout.activity_main2)
        }
        keyA = findViewById(R.id.a)
        keyB = findViewById(R.id.b)
        keyC = findViewById(R.id.c)
        keyD = findViewById(R.id.d)
        keyE = findViewById(R.id.e)
        keyF = findViewById(R.id.f)
        keyG = findViewById(R.id.g)
        keyH = findViewById(R.id.h)
        keyI = findViewById(R.id.i)
        keyJ = findViewById(R.id.j)
        keyK = findViewById(R.id.k)
        keyL = findViewById(R.id.l)
        keyM = findViewById(R.id.m)
        keyN = findViewById(R.id.n)
        keyO = findViewById(R.id.o)
        keyP = findViewById(R.id.p)
        keyQ = findViewById(R.id.q)
        keyR = findViewById(R.id.r)
        keyS = findViewById(R.id.s)
        keyT = findViewById(R.id.t)
        keyU = findViewById(R.id.u)
        keyV = findViewById(R.id.v)
        keyW = findViewById(R.id.w)
        keyX = findViewById(R.id.x)
        keyY = findViewById(R.id.y)
        keyZ = findViewById(R.id.z)
        startGame = findViewById(R.id.button)
        underscoreWords = findViewById(R.id.underscoreWord)
        wordsUsed = findViewById(R.id.wordsUsed)
        hintButton = findViewById(R.id.hintButton)
        hintResult  = findViewById(R.id.hintResult)

//        Toast.makeText(this,"${viewModel.wordsUsed}",Toast.LENGTH_LONG).show()
//
//        Toast.makeText(this,"${viewModel.underscoreWords}",Toast.LENGTH_LONG).show()

        underscoreWords.text = viewModel.underscoreWords

        wordsUsed.text = viewModel.wordsUsed
        if(viewModel.ButtonVisibility){
            enableButtons()
        }else{
            disableButtons()
        }
        checkLetter()
        Toast.makeText(this,"Recreation",Toast.LENGTH_LONG).show()
        for(element in viewModel.disableWords){
            checkDisableLetters(element)
        }
        hintButton?.setOnClickListener {
            Toast.makeText(this,"Entering Hint ",Toast.LENGTH_LONG).show()

            if(viewModel.hintTries == 0){

                hintResult?.text = viewModel.wordCategoriesMap[viewModel.wordToGuess]
                viewModel.hintTries++
                viewModel.Turns--
            }
            else if (viewModel.hintTries == 1){

                viewModel.hintTries++

                viewModel.Turns--
            }
            else if(viewModel.hintTries == 2){

                viewModel.hintTries++

                viewModel.Turns--
            }
        }
        startGame.setOnClickListener{
            viewModel.startNewGame()
            viewModel.ButtonVisibility = true
            viewModel.hintTries = 0
            if(viewModel.ButtonVisibility){
                enableButtons()
            }
            viewModel.Turns += maxTries
            viewModel.generateBlankSets(viewModel.wordToGuess)

            underscoreWords.text = viewModel.underscoreWords

            viewModel.generateLettersUsed(viewModel.usedLetter)

            wordsUsed.text = viewModel.wordsUsed
            checkLetter()
        }


    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main2_landscape)

//            Toast.makeText(this,"changed to landscape", Toast.LENGTH_LONG)
        } else {
            setContentView(R.layout.activity_main2)
//            Toast.makeText(this,"changed to portrait", Toast.LENGTH_LONG)
        }}
    private fun checkLetter(){
        keyA.setOnClickListener{
            addLetter('a')
        }
        keyB.setOnClickListener{
            addLetter('b')
        }
        keyC.setOnClickListener{
            addLetter('c')
        }
        keyD.setOnClickListener{
            addLetter('d')
        }
        keyE.setOnClickListener{
            addLetter('e')
        }
        keyF.setOnClickListener{
            addLetter('f')
        }
        keyG.setOnClickListener{
            addLetter('g')
        }
        keyH.setOnClickListener{
            addLetter('h')
        }
        keyI.setOnClickListener{
            addLetter('i')
        }
        keyJ.setOnClickListener{
            addLetter('j')
        }
        keyK.setOnClickListener{
            addLetter('k')
        }
        keyL.setOnClickListener{
            addLetter('l')
        }
        keyM.setOnClickListener{
            addLetter('m')
        }
        keyN.setOnClickListener{
            addLetter('n')
        }
        keyO.setOnClickListener{
            addLetter('o')
        }
        keyP.setOnClickListener{
            addLetter('p')
        }
        keyQ.setOnClickListener{
            addLetter('q')
        }
        keyR.setOnClickListener{
            addLetter('r')
        }
        keyS.setOnClickListener{
            addLetter('s')
        }
        keyT.setOnClickListener{
            addLetter('t')
        }
        keyU.setOnClickListener{
            addLetter('u')
        }
        keyV.setOnClickListener{
            addLetter('v')
        }
        keyW.setOnClickListener{
            addLetter('w')
        }
        keyX.setOnClickListener{
            addLetter('x')
        }
        keyY.setOnClickListener{
            addLetter('y')
        }
        keyZ.setOnClickListener{
            addLetter('z')
        }
    }
    private fun addLetter(letter:Char){
        viewModel.usedLetter.add(letter)
        viewModel.Turns--

        viewModel.disableWords+=letter
        checkDisableLetters(letter)

//        Toast.makeText(this,"Size: ${viewModel.usedLetter.size}",Toast.LENGTH_LONG).show()
        viewModel.generateLettersUsed(viewModel.usedLetter)

//        Toast.makeText(this,"${viewModel.wordsUsed}",Toast.LENGTH_LONG).show()

        wordsUsed.text = viewModel.wordsUsed
        var letterFound = false

        for(i in viewModel.wordToGuess.indices){
            if(viewModel.wordToGuess[i].equals(letter, ignoreCase =true) && !viewModel.revealedLetter.contains(viewModel.wordToGuess[i])){
                viewModel.revealedLetter.add(viewModel.wordToGuess[i])
                letterFound = true
//                Toast.makeText(this,"Guess word : ${viewModel.wordToGuess} , ${viewModel.wordToGuess[i]} FOUND !!!", Toast.LENGTH_LONG).show()
            }

        }
        if (letterFound) {
            viewModel.modifyUnderscoreWord()

//            Toast.makeText(this,"${viewModel.underscoreWords}",Toast.LENGTH_LONG).show()
            underscoreWords.text = viewModel.underscoreWords
            viewModel.winOrLos()

//            Toast.makeText(this,"${viewModel.winningCondition}",Toast.LENGTH_LONG)
            if(viewModel.usedLetter.size == viewModel.wordToGuess.length){

                if(viewModel.winningCondition){
                    Toast.makeText(this,"Won the game",Toast.LENGTH_LONG).show()
                    viewModel.ButtonVisibility = false
                    if(!viewModel.ButtonVisibility){
                        disableButtons()
                    }
                }else{

                    Toast.makeText(this,"Lost the game",Toast.LENGTH_LONG).show()
                    viewModel.ButtonVisibility = false
                    if(!viewModel.ButtonVisibility){
                        disableButtons()
                    }
                }
            }
            else if(!viewModel.underscoreWords.contains('_')){
                if(viewModel.winningCondition){
                    Toast.makeText(this,"You won the game. You can play again.",Toast.LENGTH_LONG).show()
                    viewModel.ButtonVisibility = false
                    if(!viewModel.ButtonVisibility){
                        disableButtons()
                    }
                }else{

                    Toast.makeText(this,"You lost the game. Please try again",Toast.LENGTH_LONG).show()
                    viewModel.ButtonVisibility = false
                    if(!viewModel.ButtonVisibility){
                        disableButtons()
                    }
                }
            }
        }
        else
        {
            Toast.makeText(this,"Current Tries :${viewModel.currentTries}",Toast.LENGTH_LONG).show()
            viewModel.currentTries++
            if(viewModel.Turns<0){
                Toast.makeText(this,"You lost the game. Please try again",Toast.LENGTH_LONG).show()
                viewModel.ButtonVisibility = false
                if(!viewModel.ButtonVisibility){
                    disableButtons()
                }
            }
            if(viewModel.currentTries > maxTries){
                Toast.makeText(this,"You lost the game. Please try again",Toast.LENGTH_LONG).show()
                viewModel.ButtonVisibility = false
                if(!viewModel.ButtonVisibility){
                    disableButtons()
                }
            }
        }


    }
    private fun checkDisableLetters(letter:Char){
        when (letter.toLowerCase()) {
            'a' -> keyA.isEnabled = false
            'b' -> keyB.isEnabled = false
            'c' -> keyC.isEnabled = false
            'd' -> keyD.isEnabled = false
            'e' -> keyE.isEnabled = false
            'f' -> keyF.isEnabled = false
            'g' -> keyG.isEnabled = false
            'h' -> keyH.isEnabled = false
            'i' -> keyI.isEnabled = false
            'j' -> keyJ.isEnabled = false
            'k' -> keyK.isEnabled = false
            'l' -> keyL.isEnabled = false
            'm' -> keyM.isEnabled = false
            'n' -> keyN.isEnabled = false
            'o' -> keyO.isEnabled = false
            'p' -> keyP.isEnabled = false
            'q' -> keyQ.isEnabled = false
            'r' -> keyR.isEnabled = false
            's' -> keyS.isEnabled = false
            't' -> keyT.isEnabled = false
            'u' -> keyU.isEnabled = false
            'v' -> keyV.isEnabled = false
            'w' -> keyW.isEnabled = false
            'x' -> keyX.isEnabled = false
            'y' -> keyY.isEnabled = false
            'z' -> keyZ.isEnabled = false
        }
    }
    private fun enableButtons(){
        keyA.isEnabled = true
        keyB.isEnabled = true
        keyC.isEnabled = true
        keyD.isEnabled = true
        keyE.isEnabled = true
        keyF.isEnabled = true
        keyG.isEnabled = true
        keyH.isEnabled = true
        keyI.isEnabled = true
        keyJ.isEnabled = true
        keyK.isEnabled = true
        keyL.isEnabled = true
        keyM.isEnabled = true
        keyN.isEnabled = true
        keyO.isEnabled = true
        keyP.isEnabled = true
        keyQ.isEnabled = true
        keyR.isEnabled = true
        keyS.isEnabled = true
        keyT.isEnabled = true
        keyU.isEnabled = true
        keyV.isEnabled = true
        keyW.isEnabled = true
        keyX.isEnabled = true
        keyY.isEnabled = true
        keyZ.isEnabled = true

    }
    private fun disableButtons(){
        keyA.isEnabled = false
        keyB.isEnabled = false
        keyC.isEnabled = false
        keyD.isEnabled = false
        keyE.isEnabled = false
        keyF.isEnabled = false
        keyG.isEnabled = false
        keyH.isEnabled = false
        keyI.isEnabled = false
        keyJ.isEnabled = false
        keyK.isEnabled = false
        keyL.isEnabled = false
        keyM.isEnabled = false
        keyN.isEnabled = false
        keyO.isEnabled = false
        keyP.isEnabled = false
        keyQ.isEnabled = false
        keyR.isEnabled = false
        keyS.isEnabled = false
        keyT.isEnabled = false
        keyU.isEnabled = false
        keyV.isEnabled = false
        keyW.isEnabled = false
        keyX.isEnabled = false
        keyY.isEnabled = false
        keyZ.isEnabled = false
    }

}