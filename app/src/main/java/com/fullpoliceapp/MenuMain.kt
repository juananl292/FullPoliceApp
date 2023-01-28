package com.fullpoliceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuMain : AppCompatActivity() {
    val correo:TextView by lazy {findViewById(R.id.nombreCorreo)}
    val botonRanking:Button by lazy { findViewById(R.id.botonRanking) }
    val botonTest:Button by lazy { findViewById(R.id.botonTest) }
    val botonEstadisticas:Button by lazy { findViewById(R.id.botonEstadisticas) }
    val botonOrtografia:Button by lazy { findViewById(R.id.botonOrtografia) }
    val botonTemario:Button by lazy { findViewById(R.id.botonTemario) }
    val botonNoticias:Button by lazy { findViewById(R.id.botonNoticias) }


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

        botonRanking.setOnClickListener {
            val homeIntent: Intent = Intent(this,Ranking::class.java)
            startActivity(homeIntent)
        }
        botonEstadisticas.setOnClickListener {
            val homeIntent: Intent = Intent(this,Estadisticas::class.java)
            startActivity(homeIntent)
        }
        botonNoticias.setOnClickListener {
            val homeIntent: Intent = Intent(this,Noticias::class.java)
            startActivity(homeIntent)
        }
        botonTemario.setOnClickListener {
            val homeIntent: Intent = Intent(this,Temario::class.java)
            startActivity(homeIntent)
        }
        botonTest.setOnClickListener {
            val homeIntent: Intent = Intent(this,Test::class.java)
            startActivity(homeIntent)
        }
        botonOrtografia.setOnClickListener {
            val homeIntent: Intent = Intent(this,Ortografia::class.java)
            startActivity(homeIntent)
        }

    }
}