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
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), View.OnClickListener {
    /**Declarem els botons*/
    private var btnIniciSessio: Button? = null
    private var btnRegistre: Button? = null
    private var user: EditText? = null
    private var password: EditText? = null

    /**Metode que Declarem els botons que utilitzarem i la vista que tindra la pantalla*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**Definim la vista de la pantalla que utilitzara aquesta classe*/
        setContentView(R.layout.activity_main)
        //Quan li donem als botons pasarem el id a un altre metode
        btnIniciSessio = findViewById<Button>(R.id.btnIniciSessio)
        btnRegistre = findViewById<Button>(R.id.btnRegistre)
        btnIniciSessio!!.setOnClickListener(this)
        btnRegistre!!.setOnClickListener(this)

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Message","Integració de Firebase completada")
        analytics.logEvent("InitScreen",bundle)

        //Setup
        setup()
    }

    private fun setDataFromTexBox()
    {
        user = findViewById(R.id.user)
        password = findViewById(R.id.password)
    }

    private fun setup() {
        title = "Autenticació"

        btnRegistre?.setOnClickListener{
            if (user?.text?.isNotEmpty()!! && password?.text?.isNotEmpty()!!){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(user!!.text.toString(),
                        password!!.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    }else{
                        showAlert()
                    }

                }
            }
        }
        btnIniciSessio?.setOnClickListener{
            //
            setDataFromTexBox();
            if (user?.text?.isNotEmpty()!!  && password?.text?.isNotEmpty()!!){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(user?.text.toString(),
                        password?.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    }else{
                        showAlert()
                    }

                }
            }
        }
    }

    private fun showAlert(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("S'ha produït un error en l'autentificació al usuari")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showHome(user: String, password: ProviderType){

        val homeIntent  = Intent(this, Lista::class.java).apply {
            putExtra("user",user)
            putExtra("password",password.name)
        }
        startActivity(homeIntent)
    }
    /**
     * @param v
     */
    /**Metode que entrara quan cliquem algun tipus de boto*/
    override fun onClick(v: View?){
        /**Depenen el boto que cliquem entara en una d'aquestes condicions*/
        when (v?.id) {
            /**Boto que va a la Classe Lista*/
            R.id.btnIniciSessio -> {
                val intent = Intent(this, Lista::class.java)
                startActivity(intent)
            }
            /**Boto que va a la Classe SignUp*/
            R.id.btnRegistre -> {
                val intent = Intent(this, SignUp::class.java)
                startActivity(intent)
            }
        }
    }
}