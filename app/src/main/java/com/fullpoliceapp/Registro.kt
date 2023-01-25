package com.fullpoliceapp

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.analytics.FirebaseAnalytics

class Registro : AppCompatActivity() {
    val botonRegistrar: Button by lazy { findViewById<Button>(R.id.botonRegistrar) }
    val correo: TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.correo) }
    val password:TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.contrasenaText) }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_registro)
        val analytics:FirebaseAnalytics=FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString("message","Integracion de firebase completa")
        analytics.logEvent("Initscreen",bundle)
        setup()
    }
    private fun setup(){
        title="Autentication"
        botonRegistrar.setOnClickListener {
            if(correo.getText().isNotEmpty()  && password.text.isNotEmpty()  ){

            }
        }
    }
}