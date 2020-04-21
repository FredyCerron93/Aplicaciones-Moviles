package com.example.appmanejocamara

import android.Manifest
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCamara.setOnClickListener { checkCameraPermission() }
    }

    private fun checkCameraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //no tenemos permiso
            requestCameraPermission()
        }
        else{
            Toast.makeText(this, "ya cuenta con el permiso", Toast.LENGTH_LONG).show()
        }
    }

    //aqui vamos a llamar al metodo requestPermission
    private fun requestCameraPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
            Toast.makeText(this, "Ud. Rechazo el permiso Previamente. Activalo en setting", Toast.LENGTH_LONG).show()
        }
        else{
            //metodo requestPermission
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        when (requestCode){
            CAMERA_REQUEST_CODE -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "Se autorizo acceso a la camara", Toast.LENGTH_LONG).show()
                else{
                    Toast.makeText(this, "Permiso NEGADO a la camara", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }
}