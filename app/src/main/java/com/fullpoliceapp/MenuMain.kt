package com.fullpoliceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuMain : AppCompatActivity() {
    val correo:TextView by lazy {findViewById<TextView>(R.id.nombreCorreo)}
    val botonRanking:Button by lazy { findViewById<Button>(R.id.botonRanking) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title="Menú"
        setContentView(R.layout.layout_menu_main)

        val bundle:Bundle?=intent.extras
       val emai:String?= bundle?.getString("email")
        val pass:String?=bundle?.getString("contra")
        setup(emai?:"",pass?:"")

    }
    private fun setup(email:String,contra:String){

        correo.text=email




    }
}