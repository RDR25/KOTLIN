package com.example.myapplication

import android.animation.BidirectionalTypeConverter
import android.widget.Toast
import java.util.*


fun main()
{
    var arr = arrayOf(arrayOf(12,432,84), arrayOf(554,4844,45), arrayOf(212,874,14),arrayOf(28,4644,545), arrayOf(912,74,654))
    /*for(i in arr)
    {
        println(i[0])
    }*/
    var gameState = arrayOf(0,0,0,0,0,0,0,0,0)
    var activePlayer = 1
    var gameActive = true
    var winningPos = arrayOf(arrayOf(0,1,2),arrayOf(3,4,5),arrayOf(6,7,8),arrayOf(0,3,6),arrayOf(1,4,7),arrayOf(2,5,8),arrayOf(0,4,8),arrayOf(2,4,6))
    for(i in winningPos)
    {
        println("${i[0]}   ${i[1]}   ${i[2]}" )
    }
   /* for(pos in winningPos)
    {
        if(gameState[pos[0]]!=0 && gameState[pos[0]] == gameState[pos[1]] && gameState[pos[1]] == gameState[pos[2]] )
        {
            gameActive =false
            if(activePlayer ==1)
            {
                Toast.makeText(this, "BLACK is the winner", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"White is the winner",Toast.LENGTH_LONG).show()
            }
        }
    }*/
}