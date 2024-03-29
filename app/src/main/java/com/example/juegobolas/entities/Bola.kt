package com.example.juegobolas.entities

import kotlin.math.pow
import kotlin.math.sqrt

class Bola(
    var x: Int,
    var y: Int,
    var velocidadX: Int,
    var velocidadY: Int,
    var color: String,
    var radio: Float
) {
    fun mover(anchoTablero: Int, altoTablero: Int) {
        x += velocidadX
        y += velocidadY
        cambiarTam()


        if (x <= 0 || x >= anchoTablero) {
            velocidadX *= -1
        }
        if (y <= 0 || y >= altoTablero) {
            velocidadY *= -1
        }
    }
    fun cambiarTam(){
        if (color == "#0000FF"){
            radio += 0.01f
        }
        if (color == "#FF0000"){
            radio -= 0.01f
        }
    }
    fun colisionaCon(otraBola: Bola): Boolean {
        val distanciaCentros = sqrt((x - otraBola.x).toDouble().pow(2) + (y - otraBola.y).toDouble().pow(2))
        val distanciaMinima = radio + otraBola.radio
        return distanciaCentros <= distanciaMinima
    }

    fun comerBola(otraBola: Bola) {
        if (color == "#FF0000" && otraBola.color == "#0000FF") {
            radio += otraBola.radio  // Aumentar el radio de la bola roja al comer una bola azul
        }

    }
    fun reproducir(): Bola {
        // Crear una nueva bola con la mitad de la energía y posicion distinta
        radio /= 2
        return Bola(x + 5, y + 5, velocidadX, velocidadY, color, radio)
    }

}