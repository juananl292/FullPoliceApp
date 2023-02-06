package com.fullpoliceapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat

class Noticias : AppCompatActivity() {
     val PERMISO_CAMARA: Int = 205439543
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_noticias)

        val botonPermisos:Button=findViewById(R.id.buttonPermisos)
        botonPermisos.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val intent: Intent = Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA)
                startActivity(intent)
            } else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)) {
                    Toast.makeText(this, "No se puede acceder al micro", Toast.LENGTH_LONG).show()
                }
                ActivityCompat.requestPermissions(this, Array<String>(1) { android.Manifest.permission.CAMERA },
                    this.PERMISO_CAMARA
                    //probando
                )
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == this.PERMISO_CAMARA && grantResults.size >= 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val intent: Intent = Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA)
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                "No se puede acceder a la cámara",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}