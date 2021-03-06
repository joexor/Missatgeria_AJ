package com.example.missatgeria_aj
/**
 * @author Arnau Cortés i Joel Expósito
 */
/**
* Primer de tot es s'afegeixen els imports per a que tot ens funcioni correctament.
*/

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Xat : AppCompatActivity(), View.OnClickListener {
    /**Metode que Declarem els botons que utilitzarem i la vista que tindra la pantalla*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**Definim la vista de la pantalla que utilitzara aquesta classe*/
        setContentView(R.layout.activity_xat)
        /**Declarem els botons*/
        var btnatras = findViewById<ImageButton>(R.id.btnatras)
        /**Quan li donem als botons pasarem el id a un altre metode*/
        btnatras.setOnClickListener(this)
    }
    /**
     * @param v
     */
    /**Metode que entrara quan cliquem algun tipus de boto*/
    override fun onClick(v: View?){
        /**Depenen el boto que cliquem entara en una d'aquestes condicions*/
        when (v?.id) {
            /**Boto que tancara la pantalla que tenim oberta i sortira l'anterior que teniem oberta*/
            R.id.btnatras -> {
                finish()
            }
        }
    }
}