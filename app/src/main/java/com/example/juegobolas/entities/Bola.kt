package com.example.juegobolas.entities

class Bola(var x: Int, var y: Int, var velocidadX: Int, var velocidadY: Int, var color: String) {
    fun mover(anchoTablero: Int, altoTablero: Int) {
        x += velocidadX
        y += velocidadY

        if (x <= 0 || x >= anchoTablero) {
            velocidadX *= -1
        }
        if (y <= 0 || y >= altoTablero) {
            velocidadY *= -1
        }
    }
}