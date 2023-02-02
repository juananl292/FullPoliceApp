package recycler

import android.app.Activity
import android.os.Parcel
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import clases.Temas
import com.fullpoliceapp.R
import com.fullpoliceapp.Tema
import com.google.firebase.firestore.FirebaseFirestore

class AdapterTemas(val actividadMadre:Activity,val datos:ArrayList<Temas>) :RecyclerView.Adapter<TemasViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemasViewHolder {
        return TemasViewHolder(actividadMadre.layoutInflater.inflate(R.layout.elementos_recycler,parent,false))
    }

    override fun onBindViewHolder(holder: TemasViewHolder, position: Int) {

        val tema:Temas=datos.get(position)

        holder.nombreTema.text=tema.nombreTema
        holder.tema.text=tema.indiceTema
//        if (holder.nombreTema.text.isBlank()){
//            holder.nombreTema.text="esta vacio"
//            Log.d("vacio","esta vacio")
//        }else{
//            Log.d("lleno","esta lleno")
//        }

    }

    override fun getItemCount(): Int {
       return datos.size
    }

}