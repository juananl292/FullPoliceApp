package recycler

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fullpoliceapp.R


class TemasViewHolder(view:View): ViewHolder(view){
    val tema:TextView by lazy { view.findViewById<TextView>(R.id.textTema) }
    val nombreTema:TextView by lazy { view.findViewById<TextView>(R.id.textNombreTema) }
    val botonIr:Button by lazy { view.findViewById<Button>(R.id.buttonIr) }
}