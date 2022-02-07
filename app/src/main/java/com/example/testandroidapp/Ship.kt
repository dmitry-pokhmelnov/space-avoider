package com.example.testandroidapp

import android.content.Context

class Ship : SpaceBody {

    constructor(context: Context) {
        bitmapId = R.drawable.ship;
        size = 5F;
        x = 7F;
        y = GameView.maxY - size - 1
        speed = 0.2F

        init(context)
    }

    override fun update() {
        if (MainActivity.isLeftPressed && x >= 0) {
            x -= speed
        }
        if (MainActivity.isRightPressed && x <= GameView.maxX - 5) {
            x += speed
        }
    }

}