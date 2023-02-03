package com.fullpoliceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

        val cor:TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.correo) }
        val ps:TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.password) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        val botonIniciarSesion:Button=findViewById<Button>(R.id.botonInicioSesion)
        val botonRegistro:Button=findViewById<Button>(R.id.botonRegistrar)

        botonRegistro.setOnClickListener {
            val intent:Intent=Intent(this,Registro::class.java)
            this.startActivity(intent)
        }
        botonIniciarSesion.setOnClickListener {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(cor.text.toString(),
                ps.text.toString()).addOnCompleteListener {
                if(it.isSuccessful){
                    showHome(it.result?.user?.email?:"",ps.text.toString())
                }else{
                    showAlert()
                }
            }
        }
    }
    private fun showAlert(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Usuario o contraseña incorrectos")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showHome(email:String, contra:String){
        val homeIntent:Intent=Intent(this,MenuMain::class.java).apply {this
            putExtra("email",cor.text.toString())
            putExtra("contra",ps.text.toString())
        }
        startActivity(homeIntent)
    }
}