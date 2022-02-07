package com.example.testandroidapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

open class SpaceBody {
    protected var x = 0F;
    protected var y = 0F;
    protected var size = 0F;
    protected var speed = 0F;
    protected var bitmapId = 0;
    protected lateinit var bitmap: Bitmap;

    fun init(context: Context) {
        var cBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, bitmapId)
        bitmap = Bitmap.createScaledBitmap(cBitmap, (size * GameView.unitW).toInt(), (size * GameView.unitH).toInt(), false)

        cBitmap.recycle()
    }

    open fun update() {}

    fun draw(paint: Paint, canvas: Canvas) {
        canvas.drawBitmap(bitmap, x*GameView.unitW, y*GameView.unitH, paint)
    }
}