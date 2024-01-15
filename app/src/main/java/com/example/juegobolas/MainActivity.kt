package com.example.juegobolas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.juegobolas.entities.Bola
import com.example.juegobolas.tablero.Tablero
import com.example.juegobolas.tablero.TableroView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tablero = Tablero(800, 600)  // Crear un tablero con ancho 800 y alto 600

        val bola1 = Bola(100, 100, 5, 3, "#FF0000")  // Crear una bola roja
        val bola2 = Bola(200, 200, 3, 5, "#0000FF")  // Crear una bola azul

        tablero.agregarBola(bola1)
        tablero.agregarBola(bola2)

        val tableroView = TableroView(this, tablero)
        setContentView(tableroView)  // Establecer la vista personalizada como el contenido de la actividad

        // Configurar un temporizador para actualizar el tablero y redibujar las bolas
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                tablero.actualizar()  // Actualizar la posición de las bolas
                runOnUiThread { tableroView.invalidate() }  // Redibujar la vista
            }
        }
        timer.schedule(task, 0, 1000 / 60)  // Actualizar aproximadamente 60 veces por segundo
    }
}
