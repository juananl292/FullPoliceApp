package com.fullpoliceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class Temario : AppCompatActivity() {
    private val db= FirebaseFirestore.getInstance()
    val nTema:TextView by lazy { findViewById(R.id.nombreTema) }
    val temario:TextView by lazy { findViewById(R.id.contenidoTema) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_temario)
        db.collection("temas").document("tema1").get().addOnSuccessListener {

            temario.setText(it.getString("temario"))
        }
        nTema.setText(db.collection("temas").document("tema1").id.toString())


    }
}