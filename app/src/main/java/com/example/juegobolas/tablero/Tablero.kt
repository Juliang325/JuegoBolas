package com.example.juegobolas.tablero

import com.example.juegobolas.entities.Bola

class Tablero(val ancho: Int, val alto: Int) {
    val bolas = mutableListOf<Bola>()

    fun agregarBola(bola: Bola) {
        bolas.add(bola)
    }

    fun actualizar() {
        for (bola in bolas) {
            bola.mover(ancho, alto)  // Llamar al método mover de la clase Bola
            // Aquí puedes agregar lógica para detectar colisiones entre las bolas, interacción con el usuario, etc.
        }
    }
}