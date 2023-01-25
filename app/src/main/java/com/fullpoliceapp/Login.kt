package com.fullpoliceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        val botonIniciarSesion:Button=findViewById<Button>(R.id.botonInicioSesion)
        val botonRegistro:Button=findViewById<Button>(R.id.botonRegistrar)

        botonRegistro.setOnClickListener {
            val intent:Intent=Intent(this,Registro::class.java)
            this.startActivity(intent)
        }
    }
}