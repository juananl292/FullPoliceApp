package com.fullpoliceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import clases.Temas
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import recycler.AdapterTemas

class MenuTemario : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_recycler)

         var db= FirebaseFirestore.getInstance()
        val listaTemas:ArrayList<Temas> = ArrayList<Temas>()
        db.collection("temas").get().addOnSuccessListener {
            for (documentos in it){
                var id:String?=documentos.id.toString()
                var d:String?=documentos.getString("nombre")
                val prueba:Temas= Temas(id,d,"")
               // val temaRecibido:Temas=documentos.toObject(Temas::class.java)

                listaTemas.add(prueba)
                Log.d("temas","$listaTemas")
            }
            val recyclerView:RecyclerView=findViewById<RecyclerView>(R.id.recyclerTemas)
            recyclerView.adapter=AdapterTemas(this,listaTemas)
            recyclerView.layoutManager=LinearLayoutManager(this) }

    }
}