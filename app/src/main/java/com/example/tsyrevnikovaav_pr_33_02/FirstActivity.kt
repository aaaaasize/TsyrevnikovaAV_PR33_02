package com.example.tsyrevnikovaav_pr_33_02

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FirstActivity : AppCompatActivity() {

    private lateinit var start_btn: ImageButton
    private lateinit var login_ed: EditText
    private lateinit var pass_ed: EditText

    private val MY_SETTINGS = "my_settings"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        start_btn = findViewById(R.id.start_btn)
        login_ed = findViewById(R.id.login_ed)
        pass_ed = findViewById(R.id.pass_ed)

        val sp = getSharedPreferences(
            MY_SETTINGS,
            Context.MODE_PRIVATE
        )


        start_btn.setOnClickListener {

            val hasVisited = sp.getBoolean("hasVisited", false)

            val login = login_ed.text.toString()
            val pass=pass_ed.text.toString()

            if (login == "" || pass == "") {
                Toast.makeText(
                    this, R.string.error_empty_fields, Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            if (!hasVisited) {
                val editor = sp.edit()
                editor.putBoolean("hasVisited", true)
                editor.putString("login", login)
                editor.putString("password", pass)
                editor.apply()
            }

            val correctLogin = sp.getString("login", "")
            val correctPass = sp.getString("password", "")

            Log.d("pass", correctPass.toString())
            Log.d("log", correctLogin.toString())

            if(login != correctLogin || pass != correctPass){
                Toast.makeText(
                    this, R.string.error_not_correct, Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }

}