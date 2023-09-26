package com.lespsan543.ejercicio1pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var contaPulsaciones = 0
        val texto : TextView = findViewById(R.id.textoMostrar)
        val boton : Button = findViewById(R.id.boton_aceptar)

        fun pulsar(){
            contaPulsaciones++
            var tamano = 0
            if (contaPulsaciones<=5){
                tamano = 24
            }else{
                tamano = 22
            }
            texto.textSize = tamano.toFloat()

            if (contaPulsaciones == 1){
                texto.text = "Has hecho click una vez!"
            }else if(contaPulsaciones == 2){
                texto.text = "Has hecho click dos veces!"
            }else if(contaPulsaciones>=3 && contaPulsaciones<=5){
                texto.text = "Has hecho click $contaPulsaciones veces!"
            }else if(contaPulsaciones>=6 && contaPulsaciones <=9){
                texto.text = "Has hecho click varias veces! ($contaPulsaciones)"
            }else {
                texto.text = "Te has pasado de clicks!"
                boton.setEnabled(false)
            }
        }
        boton.setOnClickListener { pulsar() }
    }
}