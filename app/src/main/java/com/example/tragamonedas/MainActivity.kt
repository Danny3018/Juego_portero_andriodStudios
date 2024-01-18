package com.example.tragamonedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.tragamonedas.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var patea_centro: Button
    lateinit var patea_derecha: Button
    lateinit var patea_izquierda: Button
    lateinit var imagenes1 : ImageView
    lateinit var texto: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Almacenando en variables productos de el mainActivity
        imagenes1 = findViewById(R.id.imageView)
        patea_derecha = findViewById(R.id.patea_derecha)
        patea_izquierda = findViewById(R.id.patea_izquierda)
        patea_centro = findViewById(R.id.patea_centro)
        texto = findViewById(R.id.textView)


        //Button Action Listener

        patea_derecha.setOnClickListener {
            penalti_derecha()
        }

        patea_izquierda.setOnClickListener {
            penalti_izquierda()
        }

        patea_centro.setOnClickListener {
            penalti_centro()
        }


    }


    private fun decision_arquero():String{

        val arquero:Int =  (1..3).random()
        var direccion_arquero = ""
        when(arquero){
            1->direccion_arquero = "Derecha"
            2->direccion_arquero = "Izquierda"
            3->direccion_arquero = "Centro"
        }
        return direccion_arquero
    }

    private fun penaltis(direccion:String, imagen:Int){

        val decision  = decision_arquero()

        if (direccion == decision){

            texto.setText("Gol Atajado")

            imagenes1.setImageResource(imagen)

        } else {

            texto.setText("Goool !! portero se fue hacia " + decision)
            imagenes1.setImageResource(R.drawable.gol)

        }
    }


    private fun penalti_derecha(){

        penaltis("Derecha", R.drawable.arquero_derecha)

    }

    private fun penalti_izquierda(){

        penaltis("Izquierda" , R.drawable.arquero_izquierda)
    }

    private fun penalti_centro(){

      penaltis("Centro" , R.drawable.arquero_centro2)

    }

}