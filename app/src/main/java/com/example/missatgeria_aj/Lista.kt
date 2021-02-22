package com.example.missatgeria_aj
/**
 * @author Arnau Cortés i Joel Expósito
 */
/**
* Primer de tot es s'afegeixen els imports per a que tot ens funcioni correctament.
*/
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

enum class ProviderType{
    BASIC
}
/**
* Seguit afegim una classe anomenada "Lista" on farem els mètodes i declaracions necessaris
*/
class Lista : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**Definim la vista de la pantalla que utilitzara aquesta clase*/
        setContentView(R.layout.activity_lista)
        /**Declarem els botons.*/
        var ImgPersona1 = findViewById<ImageButton>(R.id.ImgPersona1)
        var Persona1 = findViewById<TextView>(R.id.Persona1)
        var setting = findViewById<ImageView>(R.id.setting)

        ImgPersona1.setOnClickListener(this)
        Persona1.setOnClickListener(this)
        setting.setOnClickListener(this)
    }
    /**
     * @param v
     */
    /**Metode que entrara quan cliquem algun tipus de boto*/
    override fun onClick(v: View?){
        /**Depenen el boto que cliquem entara en una d'aquestes condicions*/
        when (v?.id) {
            /**Boto que va a la Classe Xat*/
            R.id.ImgPersona1 -> {
                val intent = Intent(this, Xat::class.java)
                startActivity(intent)
            }
            /**Boto que va a la Classe Xat*/
            R.id.Persona1 -> {
                val intent = Intent(this, Xat::class.java)
                startActivity(intent)
            }
            /**Boto que tancara la pantalla que tenim oberta i sortira l'anterior que teniem oberta*/
            R.id.setting ->{
                finish()
            }
        }
    }
}