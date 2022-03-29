package com.simplelogin

import android.content.Intent
import android.media.MediaDrm
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //obtenemos el modelo donde guardamos los datos
    val mapDatos = model();
    var campoText:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        //Llamamos setTheme y buscamos el Style
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoText=findViewById(R.id.TxtPersonName)

        val btnEnviar : Button = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener{onClick(1)}

        val btnPantalla2 : Button = findViewById(R.id.btnPantalla2)
        btnPantalla2.setOnClickListener{onClick(2)}


    }

    private fun onClick(boton : Int){
        // Obtenemos datos
        when(boton){
            1 -> {
                mostrarDatos()
            }
            2 ->{
                // se crea el intent encargada de la comunicaión entre actividades
                val intent = Intent(this,ActivityMenssage::class.java)
                // creamos el bundle para el paso de informacion entre actividades
                val miBundle:Bundle= Bundle()
                miBundle.putString("nombre",campoText!!.text.toString())
                //Le agregamos la informacion al intent para que sea enviada
                intent.putExtras(miBundle)
                //Le agregamos el llamado a la nueva actividad
                startActivity(intent)
            }
        }

    }

    private fun mostrarDatos() {
        // Obtenemos los datos
        val datos = obtenerDatos()
        // mostramos los datos
        for(key in mapDatos.keys){
            // Mostrar
            println("-> PERSONA = ${key} ${mapDatos[key]}")
        }
        println("Datos :: " + datos)
        println("Cantidad de Datos :: ${mapDatos.size}")
    }

    private fun obtenerDatos(){

        //Obtenemos los valores
        var document : String = findViewById<EditText?>(R.id.txt_docum).text.toString();
        var name : String = findViewById<EditText?>(R.id.txt_name).text.toString()
        var email : String = findViewById<EditText?>(R.id.txt_email).text.toString()
        var password : String = findViewById<EditText?>(R.id.txt_pass).text.toString()
        // creamos la lista inmutable, y agregamos los datos

        //Lista de datos
        val lista : MutableList<String> = mutableListOf(document,name,email,password)

        if (mapDatos.isEmpty()){
            putModel(lista)
        }else {
            for ( documentMap in mapDatos.keys){
                if((document == documentMap)){
                    val toast = Toast(this).apply{
                        setText("User exist! ")
                    }
                    println("USER EXIST!!")
                    toast.show()
                }else{
                    putModel(lista)
                }
            }
        }

    }

    private fun putModel(listaDatos : MutableList<String>){
        // Agregamos al mapa
        mapDatos.put(listaDatos[0],listaDatos)
        // Toast
        val toast = Toast(this).apply{
            setText("PERSONA = ${listaDatos[1]} \nDATOS  ${listaDatos}")
        }
        toast.show()
    }

    // Funcion que retorna el modelo

    private fun model() : MutableMap<String, Any?> {
        var mapDatos : MutableMap<String, Any?> = mutableMapOf<String, Any?>();
        return mapDatos;
    }


}