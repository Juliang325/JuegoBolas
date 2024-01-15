package com.example.juegobolas.tablero

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class TableroView(context: Context, val tablero: Tablero) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (bola in tablero.bolas) {
            paint.color = Color.parseColor(bola.color)
            canvas.drawCircle(bola.x.toFloat(), bola.y.toFloat(), 20f, paint)  // Dibujar la bola en el lienzo
        }
    }
}