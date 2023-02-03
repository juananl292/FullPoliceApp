package com.fullpoliceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import clases.Temas
import com.google.firebase.firestore.FirebaseFirestore

class Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_test_list_view)

        var db = FirebaseFirestore.getInstance()
        val listaTemas: ArrayList<Temas> = ArrayList<Temas>()
        db.collection("temas").get().addOnSuccessListener {
            for (documentos in it) {
                var id: String? = documentos.id.toString()
                var d: String? = documentos.getString("nombre")
                val prueba: Temas = Temas(id, d, "")
                // val temaRecibido:Temas=documentos.toObject(Temas::class.java)

                listaTemas.add(prueba)
                Log.d("temas", "$listaTemas")
            }
            val adapter:ArrayAdapter<Temas> = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaTemas)
            val listView:ListView=findViewById(R.id.contenedorLista)
            listView.adapter=adapter
        }
    }
}