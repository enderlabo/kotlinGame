package com.example.myapplication.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_img.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var turn : Int = 0
    var PlayerPoints1: Int = 0
    var PlayerPoints2: Int = 0
    var FirstCard: Int = 0
    var SecondCard: Int  = 0
    var FirstClick: Int = 0
    var SecondClick: Int = 0
    var NumberCard: Int = 1

    var cards = ArrayList<Int>(listOf(11,12,13,14,15,21,22,23,24,25))

    var imagen11:Int = 0
    var imagen12:Int = 0
    var imagen13:Int = 0
    var imagen14:Int = 0
    var imagen15:Int = 0

    var imagen21:Int = 0
    var imagen22:Int = 0
    var imagen23:Int = 0
    var imagen24:Int = 0
    var imagen25:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set interface User
        setUpUI()
        //load Cards
        loadCards()
        //sort cards
        cards.shuffle()
        //setup of onClick
        setUpOnClickListener()
    }

    private fun setUpUI() {
        mainActivityP1.setTextColor(Color.GREEN)
        mainActivityP1.setTypeface(null, Typeface.BOLD)

        mainActivityP2.setTextColor(Color.GRAY)
        mainActivityP2.setTypeface(null, Typeface.NORMAL)
    }

    private fun loadCards(){
        imagen11 = R.drawable.ic_black_bike
        imagen12 = R.drawable.ic_black_boat
        imagen13 = R.drawable.ic_email
        imagen14 = R.drawable.ic_black_car
        imagen15 = R.drawable.ic_black_fly

        imagen21 = R.drawable.ic_black_bike
        imagen22 = R.drawable.ic_black_boat
        imagen23 = R.drawable.ic_email
        imagen24 = R.drawable.ic_black_car
        imagen25 = R.drawable.ic_black_fly

    }

    private fun setUpOnClickListener(){
        //img from card_img
        iv11.setOnClickListener(){
            var card: Int = 0
            addImgCard(iv11, card)
        }

        iv12.setOnClickListener(){
            var card: Int = 1
            addImgCard(iv12, card)
        }

        iv13.setOnClickListener(){
            var card: Int = 2
            addImgCard(iv13, card)
        }

        iv21.setOnClickListener(){
            var card: Int = 3
            addImgCard(iv21, card)
        }

        iv22.setOnClickListener(){
            var card: Int = 4
            addImgCard(iv22, card)
        }

        iv23.setOnClickListener(){
            var card: Int = 5
            addImgCard(iv23, card)
        }

        iv31.setOnClickListener(){
            var card: Int = 6
            addImgCard(iv31, card)
        }

        iv32.setOnClickListener(){
            var card: Int = 7
            addImgCard(iv32, card)
        }

        iv41.setOnClickListener(){
            var card: Int = 8
            addImgCard(iv41, card)
        }

        iv42.setOnClickListener(){
            var card: Int = 9
            addImgCard(iv42, card)
        }


    }


private fun addImgCard(image: ImageView, card: Int){
    when(cards[card]){
        11 -> image.setImageResource(imagen11)
        12 -> image.setImageResource(imagen12)
        13 -> image.setImageResource(imagen13)
        14 -> image.setImageResource(imagen14)
        15 -> image.setImageResource(imagen15)

        21 -> image.setImageResource(imagen21)
        22 -> image.setImageResource(imagen22)
        23 -> image.setImageResource(imagen23)
        24 -> image.setImageResource(imagen24)
        25 -> image.setImageResource(imagen25)
    }
    if(NumberCard == 1) {
        FirstCard = cards[card]
        if ( FirstCard > 20) {
            FirstCard = FirstCard - 10
        }
        NumberCard = 2
        FirstClick = card
        image.isEnabled = false
    }else if( NumberCard == 2){
        SecondCard = cards[card]
        if (SecondCard > 20) {
            SecondCard = SecondCard - 10
        }
        NumberCard = 1
        SecondClick = card

        iv11.isEnabled = false
        iv12.isEnabled = false
        iv13.isEnabled = false
        iv21.isEnabled = false
        iv22.isEnabled = false
        iv23.isEnabled = false
        iv31.isEnabled = false
        iv32.isEnabled = false
        iv41.isEnabled = false
        iv42.isEnabled = false

        var handler = Handler()
        handler.postDelayed(Runnable {
            checkIsTrue()
        },1000)
    }
}

    @SuppressLint("SetTextI18n")
    private fun checkIsTrue(){
        if( FirstCard == SecondCard ) {
            when( FirstClick ) {
                0 -> iv11.visibility = View.INVISIBLE
                1 -> iv12.visibility = View.INVISIBLE
                2 -> iv13.visibility = View.INVISIBLE
                3 -> iv21.visibility = View.INVISIBLE
                4 -> iv22.visibility = View.INVISIBLE
                5 -> iv23.visibility = View.INVISIBLE
                6 -> iv31.visibility = View.INVISIBLE
                7 -> iv32.visibility = View.INVISIBLE
                8 -> iv41.visibility = View.INVISIBLE
                9 -> iv42.visibility = View.INVISIBLE
            }

            when( SecondClick ) {
                0 -> iv11.visibility = View.INVISIBLE
                1 -> iv12.visibility = View.INVISIBLE
                2 -> iv13.visibility = View.INVISIBLE
                3 -> iv21.visibility = View.INVISIBLE
                4 -> iv22.visibility = View.INVISIBLE
                5 -> iv23.visibility = View.INVISIBLE
                6 -> iv31.visibility = View.INVISIBLE
                7 -> iv32.visibility = View.INVISIBLE
                8 -> iv41.visibility = View.INVISIBLE
                9 -> iv42.visibility = View.INVISIBLE
            }

            if( turn == 1 ) {
                PlayerPoints1++
                mainActivityP1.text = "Player1:$PlayerPoints1"
            } else {
                PlayerPoints2++
                mainActivityP2.text = "Player2:$PlayerPoints2"
            }
        } else {
            iv11.setImageResource(R.drawable.ic_black_box)
            iv12.setImageResource(R.drawable.ic_black_box)
            iv13.setImageResource(R.drawable.ic_black_box)

            iv21.setImageResource(R.drawable.ic_black_box)
            iv22.setImageResource(R.drawable.ic_black_box)
            iv23.setImageResource(R.drawable.ic_black_box)

            iv31.setImageResource(R.drawable.ic_black_box)
            iv32.setImageResource(R.drawable.ic_black_box)

            iv41.setImageResource(R.drawable.ic_black_box)
            iv42.setImageResource(R.drawable.ic_black_box)

            if ( turn == 1) {

                turn = 2
                mainActivityP1.setTextColor( resources.getColor(R.color.colorGray))
                mainActivityP1.setTypeface(null, Typeface.NORMAL)

                mainActivityP2.setTextColor( resources.getColor(R.color.colorBlue))
                mainActivityP2.setTypeface(null, Typeface.BOLD)
            } else {
                turn = 1
                mainActivityP1.setTextColor( resources.getColor(R.color.colorGreen))
                mainActivityP1.setTypeface(null, Typeface.BOLD)

                mainActivityP2.setTextColor( resources.getColor(R.color.colorGray))
                mainActivityP2.setTypeface(null, Typeface.NORMAL)
            }
        }

        iv11.isEnabled = true
        iv12.isEnabled = true
        iv13.isEnabled = true

        iv21.isEnabled = true
        iv22.isEnabled = true
        iv23.isEnabled = true

        iv31.isEnabled = true
        iv32.isEnabled = true

        iv41.isEnabled = true
        iv42.isEnabled = true

        endGame()
    }

    private fun endGame() {
        if( iv11.visibility == View.INVISIBLE &&
            iv12.visibility == View.INVISIBLE &&
            iv13.visibility == View.INVISIBLE &&
            iv21.visibility == View.INVISIBLE &&
            iv22.visibility == View.INVISIBLE &&
            iv23.visibility == View.INVISIBLE &&
            iv31.visibility == View.INVISIBLE &&
            iv32.visibility == View.INVISIBLE &&
            iv41.visibility == View.INVISIBLE &&
            iv42.visibility == View.INVISIBLE ) {

            var alertDialog = AlertDialog.Builder(this@MainActivity).create()
            alertDialog.setTitle("End Game")
            alertDialog.setMessage("Player 1: $PlayerPoints1, \nPlayer 2: $PlayerPoints2")
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok"){
                dialogInterface, i ->
                var intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            alertDialog.show()
        }
    }
}


