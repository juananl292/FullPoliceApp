package com.fullpoliceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuMain : AppCompatActivity() {
    val correo:TextView by lazy {findViewById<TextView>(R.id.nombreCorreo)}
    val pass:TextView by lazy { findViewById<TextView>(R.id.nombrePass) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_menu_main)
        val bundle:Bundle?=intent.extras
       val emai:String?= bundle?.getString("email")
        val pass:String?=bundle?.getString("contra")
        setup(emai?:"",pass?:"")
    }
    private fun setup(email:String,contra:String){
        title="Inicio"
        correo.text=email
        pass.text=contra



    }
}