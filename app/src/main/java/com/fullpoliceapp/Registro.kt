package com.fullpoliceapp

import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Registro : AppCompatActivity() {
    private val db=FirebaseFirestore.getInstance()
    val botonRegistra: Button by lazy { findViewById<Button>(R.id.botonRegis) }
    val name:TextInputEditText by lazy { findViewById(R.id.nombre) }
    val correo: TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.correo) }
    val password:TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.contrasenaText) }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_registro)
        val analytics:FirebaseAnalytics=FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString("message","Integracion de firebase completa")
        analytics.logEvent("Initscreen",bundle)

        botonRegistra.setOnClickListener {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo.text.toString(),
                password.text.toString()).addOnCompleteListener {
                if(it.isSuccessful){
                    db.collection("users").document(correo.text.toString()).set(
                        hashMapOf("email" to correo.text.toString(),
                        "name" to name.text.toString())
                    )
                    showHome(it.result?.user?.email?:"",password.text.toString())
                }else{
                    showAlert()
                }
            }

        }

    }

    private fun showAlert(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("error")
        builder.setMessage("se ha producido un error al autenticar el usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog= builder.create()
        dialog.show()
    }
    private fun showHome(email:String, contra:String){
        val homeIntent:Intent=Intent(this,MenuMain::class.java).apply {this
            putExtra("email",correo.text.toString())
            putExtra("contra",password.text.toString())
        }
        startActivity(homeIntent)
    }
}