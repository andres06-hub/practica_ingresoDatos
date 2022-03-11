package com.simplelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnviar : Button = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener{onClick()}

    }



    private fun onClick(){




    }

    private fun obtenerDatos(){

        //obtenemos el modelo donde guardamos los datos
        var datos = model();



        //Obtenemos los valores
        var documet : EditText = findViewById(R.id.txt_docum)
        var name : EditText = findViewById(R.id.txt_name)
        var email : EditText = findViewById(R.id.txt_email)
        var password : EditText = findViewById(R.id.txt_pass)
    }

    // Funcion que retorna el modelo
    private fun model() : MutableMap<String, String> {
        var mapDatos = mutableMapOf<String, String>();
        return mapDatos;
    }


}