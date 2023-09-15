package com.example.tsyrevnikovaav_pr_33_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class FierdActivity : AppCompatActivity() {
    private lateinit var digit_tw: TextView
    private lateinit var start_tw: TextView
    private lateinit var end_tw: TextView
    private lateinit var result_tw: TextView
    private lateinit var registration_btn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fierd_activity)

        val bytesArray = resources.getStringArray(R.array.bytesNames)

        digit_tw=findViewById(R.id.entered_digit_tw)
        start_tw=findViewById(R.id.from_tw)
        end_tw=findViewById(R.id.to_tw)
        result_tw=findViewById(R.id.result_tw)
        registration_btn=findViewById(R.id.registration_btn)

        val enteredDigit = intent.getLongExtra("enteredDigit",0)
        val startBytes = intent.getIntExtra("startBytes",0)
        val endBytes = intent.getIntExtra("endBytes",0)
        val result = intent.getLongExtra("result",0)

        digit_tw.text=enteredDigit.toString()
        start_tw.text=bytesArray[startBytes].toString()
        end_tw.text=bytesArray[endBytes].toString()
        result_tw.text=result.toString()

        registration_btn.setOnClickListener {
            val intent = Intent(this,FirstActivity::class.java)
            startActivity(intent)
        }
    }
}