package com.example.juegobolas.tablero

import com.example.juegobolas.entities.Bola

class Tablero(var ancho: Int, var alto: Int) {
    val bolas = mutableListOf<Bola>()
    fun agregarBola(bola: Bola) {
        bolas.add(bola)
    }
    fun actualizar() {
        val bolasNuevas = mutableListOf<Bola>()  // Lista temporal para almacenar las bolas que deben ser eliminadas
        for (bola in bolas) {

            bola.mover(ancho, alto)  // Llamar al método mover de la clase Bola
            // Aquí puedes agregar lógica para detectar colisiones entre las bolas, interacción con el usuario, etc.
            if (bola.radio >= 200){
                bola.reproducir()
                bolasNuevas.add(bola.reproducir())
            }
        }
        // Añadir las bolas que deben ser creadas
        for (bolaACrear in bolasNuevas) {
            bolas.add(bolaACrear)
        }
    }

    fun manejarColisiones() {
        val bolasABorrar = mutableListOf<Bola>()  // Lista temporal para almacenar las bolas que deben ser eliminadas

        for (i in 0 until bolas.size) {
            for (j in (i + 1) until bolas.size) {
                val bola1 = bolas[i]
                val bola2 = bolas[j]

                if (bola1.colisionaCon(bola2)) {
                    bola1.comerBola(bola2)  // Verificar si la bola roja come una bola azul
                    bolasABorrar.add(bola2)  // Agregar la bola azul a la lista temporal
                    // Aquí podrías añadir más lógica de colisiones si es necesario
                }
            }
        }

        // Eliminar las bolas que deben ser borradas
        for (bolaABorrar in bolasABorrar) {
            bolas.remove(bolaABorrar)
        }
    }
}