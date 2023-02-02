package clases

import android.os.Parcel
import android.os.Parcelable

class Temas : Parcelable{
    var indiceTema:String?
    var nombreTema:String?
    var temario:String?

    constructor(parcel: Parcel) : this() {
        indiceTema = parcel.readString()
        nombreTema = parcel.readString()
        temario = parcel.readString()
    }
    constructor(indiceTema:String?="",nombreTema:String?,temario:String=""){
        this.indiceTema=indiceTema
        this.nombreTema=nombreTema
        this.temario=temario
    }

    constructor(){
        this.indiceTema=""
        this.nombreTema=""
        this.temario=""
    }

    override fun toString(): String {
        return indiceTema+" "+nombreTema+" "+temario
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(indiceTema)
        parcel.writeString(nombreTema)
        parcel.writeString(temario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Temas> {
        override fun createFromParcel(parcel: Parcel): Temas {
            return Temas(parcel)
        }

        override fun newArray(size: Int): Array<Temas?> {
            return arrayOfNulls(size)
        }
    }


}