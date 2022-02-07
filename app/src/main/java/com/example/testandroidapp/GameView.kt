package com.example.testandroidapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView : SurfaceView, Runnable {
    companion object {
        var maxX = 20
        var maxY = 28
        var unitW = 0
        var unitH = 0
    }

    private var firstTime = true
    private var gameRunning = true
    private lateinit var ship: Ship
    private var gameThread: Thread = Thread(this)
    private var paint: Paint = Paint()
    private var canvas: Canvas = Canvas()
    private var surfaceHolder: SurfaceHolder = holder

    constructor(context: Context) : super(context) {
        gameThread.start()
    }

    override fun run() {
        while (gameRunning) {
            update()
            draw()
            control()
        }
    }

    private fun update() {
        if (!firstTime) {
            ship.update()
        }
    }

    private fun draw() {
        if (surfaceHolder.surface.isValid) {
            if (firstTime) {
                firstTime = false
                unitW = surfaceHolder.surfaceFrame.width() / maxX
                unitH = surfaceHolder.surfaceFrame.height() / maxY

                ship = Ship(context)
            }

            canvas = surfaceHolder.lockCanvas()
            canvas.drawColor(Color.BLACK)

            ship.draw(paint, canvas)

            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }

    private fun control() {
        try {
            Thread.sleep(17)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

}