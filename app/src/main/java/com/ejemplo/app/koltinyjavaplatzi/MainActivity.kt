package com.ejemplo.app.koltinyjavaplatzi

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtPassw: EditText
    lateinit var btn1: Button
    lateinit var edtUser: EditText
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPassw = findViewById(R.id.edtPassword)
        edtUser = findViewById(R.id.edtUser)
        btn1 = findViewById(R.id.btnLogin)

        val sharedPreferences = getSharedPreferences("Kotlinpre",Context.MODE_PRIVATE)
        val isLoged = sharedPreferences.getBoolean("Logeado", false)
        if (isLoged){
            startActivity(Intent(this@MainActivity, ListadoActivity::class.java))
            finish()
        }

        btn1.setOnClickListener {
            val isValid = edtPassw.passwordValida()
            Log.e(TAG, "Dando click al botón login: $isValid")
            if (isValid) {
                //iniciarVista
                //startActivity(Intent(this@MainActivity, ListadoActivity::class.java))
                val intent = Intent(this@MainActivity,ListadoActivity::class.java)
                intent.putExtra("usuario", edtUser.text.toString())
                startActivity(intent)
                sharedPreferences.edit{
                    putBoolean("Logeado", true)
                }

            } else {
                Toast.makeText(this@MainActivity, "Password inváilido", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
