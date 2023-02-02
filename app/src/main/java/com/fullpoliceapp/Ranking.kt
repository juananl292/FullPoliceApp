package com.fullpoliceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class Ranking : AppCompatActivity() {
   val db= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_ranking)

        val listaUsiario:MutableList<Tema> = mutableListOf<Tema>()
        db.collection("temas").get().addOnSuccessListener {
            for (documentos in it){
                val temaRecibido:Tema=documentos.toObject(Tema::class.java)

                listaUsiario.add(temaRecibido)



            }
          //  Log.d("temas","$listaUsiario")
        }
    }
}