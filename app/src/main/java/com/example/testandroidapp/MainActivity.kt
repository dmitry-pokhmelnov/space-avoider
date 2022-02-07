package com.example.testandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gameView: GameView = GameView(this)
        var gameLayout: LinearLayout = findViewById(R.id.gameLayout)

        var leftButton: Button = findViewById(R.id.leftButton)
        var rightButton: Button = findViewById(R.id.rightButton)

        leftButton.setOnTouchListener(this)
        rightButton.setOnTouchListener(this)
    }

    companion object {
        var isLeftPressed = false
        var isRightPressed = false
    }

    override fun onTouch(button: View, motion: MotionEvent): Boolean {
        when (button.id) {
            R.id.leftButton -> when (motion.action) {
                MotionEvent.ACTION_DOWN -> isLeftPressed = true
                MotionEvent.ACTION_UP -> isLeftPressed = false
                else -> print(motion.action)
            }
            R.id.rightButton -> when (motion.action) {
                MotionEvent.ACTION_DOWN -> isRightPressed = true
                MotionEvent.ACTION_UP -> isRightPressed = false
                else -> print(motion.action)
            }
            else -> true
        }

        return true
    }
}

