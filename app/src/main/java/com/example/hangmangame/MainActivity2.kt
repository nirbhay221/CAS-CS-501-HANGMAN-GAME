package com.example.hangmangame

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.text.StringBuilder

class MainActivity2 : AppCompatActivity() {
    private val maxTries = 10
    private var currentTries = 0
    private lateinit var blankWords:String
    private lateinit var wordToGuess: String
    private var lettersUsed: String = ""
    private var usedLetter = mutableListOf<Char>()

    private var revealedLetter = mutableListOf<Char>()


    private val wordCategoriesMap = mapOf(
        "apple" to "Fruit",
        "banana" to "Fruit",
        "cherry" to "Fruit",
        "date" to "Fruit",
        "elderberry" to "Fruit",
        "blueberry" to "Fruit",
        "pineapple" to "Fruit",
        "watermelon" to "Fruit",
        "raspberry" to "Fruit",
        "elephant" to "Animal",
        "lion" to "Animal",
        "penguin" to "Animal",
        "dolphin" to "Animal",
        "india" to "Country",
        "australia" to "Country",
        "canada" to "Country",
        "japan" to "Country",
        "brazil" to "Country",
        "germany" to "Country",
        "baseball" to "Sports",
        "tennis" to "Sports",
        "swimming" to "Sports",
        "soccer" to "Sports",
        "volleyball" to "Sports",
        "mercury" to "Planets",
        "venus" to "Planets",
        "earth" to "Planets",
        "mars" to "Planets",
        "jupiter" to "Planets",
        "neptune" to "Planets",
        "saturn" to "Planets",
        "uranus" to "Planets",
        "engineer" to "Profession",
        "musician" to "Profession",
        "astronaut" to "Profession",
        "doctor" to "Profession",
        "chef" to "Profession"
    )
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

        startGame.setOnClickListener{
            startNewGame()
        }
        startNewGame()
        checkLetter()


    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main2_landscape)

            Toast.makeText(this,"changed to landscape", Toast.LENGTH_LONG)
        } else {
            setContentView(R.layout.activity_main2)
            Toast.makeText(this,"changed to portrait", Toast.LENGTH_LONG)
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
        usedLetter.add(letter)
        generateLettersUsed(usedLetter)
        var letterFound = false
        for(i in wordToGuess.indices){
            if(wordToGuess[i].equals(letter, ignoreCase =true) && !revealedLetter.contains(wordToGuess[i])){
                revealedLetter.add(wordToGuess[i])
                letterFound = true
                Toast.makeText(this,"FOUND !!!", Toast.LENGTH_LONG).show()
            }

        }
        if (letterFound) {
            val updatedWord = StringBuilder()

            for (i in wordToGuess.indices) {
                if (revealedLetter.contains(wordToGuess[i])) {
                    updatedWord.append(wordToGuess[i])
                } else {
                    updatedWord.append('_')
                }

                if (i < wordToGuess.length - 1) {
                    updatedWord.append(' ')
                }
            }

            underscoreWords.text = updatedWord.toString()
        }



        if(usedLetter.size == wordToGuess.length){
            checkGameConditions()
        }
        else if (!underscoreWords.text.contains('_')) {
            checkGameConditions()
        }



    }
    private fun startNewGame(){
        lettersUsed = ""
        currentTries = 0
        usedLetter.clear()
        revealedLetter.clear()
        enableButtons()
        val randomIndex = Random.nextInt(0,wordCategoriesMap.size)
        val valueList = wordCategoriesMap.keys.toList()
        wordToGuess = valueList[randomIndex]
        generateBlankSets(wordToGuess)
        generateLettersUsed(usedLetter)

     }
    private fun generateLettersUsed(usedLetter:List<Char>){
        val lettersUsedString = usedLetter.joinToString(", ")
        if(lettersUsedString.isEmpty()){
            wordsUsed.text = "No Letters used yet."
        }
        else{
            wordsUsed.text = "Letters used : {$lettersUsedString}"
        }
    }
    private fun generateBlankSets(word: String):String{
        val blankRepresentation = StringBuilder()
        val presentationString = StringBuilder()
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
        for(char in blankRepresentation.toString()){
            presentationString.append(char)
            presentationString.append(' ')
        }

        underscoreWords.text = presentationString
        return blankRepresentation.toString()
    }

    private fun checkGameConditions(){
        Toast.makeText(this,"Underscore String : ${underscoreWords.text}, Word To Guess : ${wordToGuess}",Toast.LENGTH_LONG).show()

        var underscoreTextString = underscoreWords.text.toString()

        var cleanedUnderscoreText = underscoreTextString.replace(" ", "").replace(",", "")


        if(cleanedUnderscoreText== wordToGuess){
            Toast.makeText(this,"You Won !! Want to Play Again ? Press on the Start new game Button",Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this,"You Lost :( I think you can try again to win it. Press on the Start new game Button",Toast.LENGTH_LONG).show()

        }
        disableButtons()

//        if(currentTries > maxTries){
//
//            Toast.makeText(this,"You Lost :( I think you can try again to win it. Press on the Start new game Button",Toast.LENGTH_LONG).show()
//        }


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