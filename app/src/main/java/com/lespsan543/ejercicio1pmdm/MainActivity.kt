package com.lespsan543.ejercicio1pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var botonLateInit : Button
    private lateinit var textLateInit : TextView
    var contaPulsaciones = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val texto : TextView = findViewById(R.id.textoMostrar)
        val boton : Button = findViewById(R.id.boton_aceptar)

        //Primera versión
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
                val toast = Toast.makeText(this,"El botón ha sido deshabilitado",Toast.LENGTH_SHORT)
                toast.show()
            }
        }


        /**
        //Segunda versión con variables de clase y lateinit
        botonLateInit = findViewById(R.id.boton_aceptar)
        textLateInit = findViewById(R.id.textoMostrar)
        fun pulsarLateInit(){
            contaPulsaciones++
            var tamano = 0
            if (contaPulsaciones<=5){
                tamano = 24
            }else{
                tamano = 22
            }
            textLateInit.textSize = tamano.toFloat()

            if (contaPulsaciones == 1){
                textLateInit.text = "Has hecho click una vez!"
            }else if(contaPulsaciones == 2){
                textLateInit.text = "Has hecho click dos veces!"
            }else if(contaPulsaciones>=3 && contaPulsaciones<=5){
                textLateInit.text = "Has hecho click $contaPulsaciones veces!"
            }else if(contaPulsaciones>=6 && contaPulsaciones <=9){
                textLateInit.text = "Has hecho click varias veces! ($contaPulsaciones)"
            }else {
                textLateInit.text = "Te has pasado de clicks!"
                botonLateInit.setEnabled(false)
                val toast = Toast.makeText(this,"El botón ha sido deshabilitado",Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        **/
        boton.setOnClickListener { pulsar() }
        //botonLateInit.setOnClickListener { pulsarLateInit() }
    }
}