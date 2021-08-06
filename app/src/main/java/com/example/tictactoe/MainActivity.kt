package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var TAG:String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        var button = view as Button
        Log.d(TAG, "buttonClick: Button ${button.id.toString()} was clicked ")
        var cell_id: Int=0
        when(button.id){
            R.id.button1->cell_id=1
            R.id.button2->cell_id=2
            R.id.button3->cell_id=3
            R.id.button4->cell_id=4
            R.id.button5->cell_id=5
            R.id.button6->cell_id=6
            R.id.button7->cell_id=7
            R.id.button8->cell_id=8
            R.id.button9->cell_id=9
        }
        playGame(button,cell_id)

    }
    var player=1
    var player1_array = ArrayList<Int>()
    var player2_array = ArrayList<Int>()
    var player1wins=0
    var player2wins=0

    fun autoplay(){
        var unchecked_box = ArrayList<Int>()
        for( i in 1..9){
            if(!player1_array!!.contains(i) && !player2_array!!.contains(i)){
                unchecked_box.add(i)
            }
        }
        if(unchecked_box.isEmpty()){
            restartGame()
            return
        }
        var r = Random()
        var index = r.nextInt(unchecked_box.size)
        val cellId = unchecked_box[index]

        var buttonSelected:Button?
        buttonSelected = when(cellId){
            1-> findViewById(R.id.button1)
            2-> findViewById(R.id.button2)
            3-> findViewById(R.id.button3)
            4-> findViewById(R.id.button4)
            5-> findViewById(R.id.button5)
            6-> findViewById(R.id.button6)
            7-> findViewById(R.id.button7)
            8-> findViewById(R.id.button8)
            9-> findViewById(R.id.button9)

            else-> findViewById(R.id.button1)
        }
        gamewinner()
        playGame(buttonSelected,cellId)


    }

    fun playGame(button:Button, cell_id: Int){
        if(player==1){
            button.setText("X")
            button.setBackgroundResource(R.color.yellow)
            player1_array!!.add(cell_id)
            player=2
            button.isEnabled =false
            if(!gamewinner()) { autoplay()}

        }else{
            button.setText("O")
            button.setBackgroundResource(R.color.blue)
            player2_array!!.add(cell_id)
            player=1
            button.isEnabled =false
            gamewinner()
        }


    }

    fun gamewinner():Boolean{
        var winner=-1
        if(player1_array!!.contains(1) && player1_array!!.contains(3) && player1_array!!.contains(2)){
            winner=1
        }
        if(player2_array!!.contains(1) && player2_array!!.contains(3) && player2_array!!.contains(2)){
            winner=2
        }
        if(player1_array!!.contains(4) && player1_array!!.contains(5) && player1_array!!.contains(6)){
            winner=1
        }
        if(player2_array!!.contains(4) && player2_array!!.contains(5) && player2_array!!.contains(6)){
            winner=2
        }

        if(player1_array!!.contains(7) && player1_array!!.contains(8) && player1_array!!.contains(9)){
            winner=1
        }
        if(player2_array!!.contains(7) && player2_array!!.contains(8) && player2_array!!.contains(9)){
            winner=2
        }
        if(player1_array!!.contains(1) && player1_array!!.contains(4) && player1_array!!.contains(27)){
            winner=1
        }
        if(player2_array!!.contains(1) && player2_array!!.contains(4) && player2_array!!.contains(7)) {
            winner = 2
        }
        if(player1_array!!.contains(2) && player1_array!!.contains(5) && player1_array!!.contains(8)){
            winner=1
        }
        if(player2_array!!.contains(2) && player2_array!!.contains(5) && player2_array!!.contains(8)){
            winner=2
        }
        if(player1_array!!.contains(3) && player1_array!!.contains(6) && player1_array!!.contains(9)){
            winner=1
        }
        if(player2_array!!.contains(3) && player2_array!!.contains(6) && player2_array!!.contains(9)){
            winner=2
        }
        if(player1_array!!.contains(1) && player1_array!!.contains(5) && player1_array!!.contains(9)){
            winner=1
        }
        if(player2_array!!.contains(1) && player2_array!!.contains(5) && player2_array!!.contains(9)){
            winner=2
        }
        if(player1_array!!.contains(3) && player1_array!!.contains(5) && player1_array!!.contains(7)){
            winner=1
        }
        if(player2_array!!.contains(3) && player2_array!!.contains(5) && player2_array!!.contains(7)){
            winner=2
        }
        if(winner==1){
        Toast.makeText(this,"Winner is $winner",Toast.LENGTH_SHORT).show()
            Log.d(TAG, "gamewinner: Winner 1")
            restartGame()
            player1wins+=1
            return true
        }

        else if(winner==2){
            Toast.makeText(this,"Winner is $winner",Toast.LENGTH_SHORT).show()
            Log.d(TAG, "gamewinner: Winner 1")
            restartGame()
            player2wins+=1
            return true
        }
        return false
    }
    fun restartGame(){
        player =1
        player1_array.clear()
        player2_array.clear()
        for(i in 1..9){
            var buttonSelected: Button?
            buttonSelected=when(i){
                1-> findViewById(R.id.button1)
                2-> findViewById(R.id.button2)
                3-> findViewById(R.id.button3)
                4-> findViewById(R.id.button4)
                5-> findViewById(R.id.button5)
                6-> findViewById(R.id.button6)
                7-> findViewById(R.id.button7)
                8-> findViewById(R.id.button8)
                9-> findViewById(R.id.button9)
                else->findViewById(R.id.button1)
            }
            buttonSelected.text=""
            buttonSelected.setBackgroundResource(R.color.offwhite)
            buttonSelected.isEnabled=true
        }

    }

}