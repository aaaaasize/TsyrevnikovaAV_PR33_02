package com.example.tsyrevnikovaav_pr_33_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var digit_ed: EditText
    private lateinit var start_spn: Spinner
    private lateinit var end_spn: Spinner
    private lateinit var resultat_tw: TextView
    private lateinit var calculate_btn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        digit_ed = findViewById(R.id.digit_ed)
        start_spn = findViewById(R.id.start_spn)
        end_spn = findViewById(R.id.end_spn)
        resultat_tw = findViewById(R.id.resultat_tw)
        calculate_btn = findViewById(R.id.calculate_btn)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.bytesNames,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        start_spn.adapter = adapter
        end_spn.adapter = adapter
        end_spn.setSelection(2)

        calculate_btn.setOnClickListener {
            val intent = Intent(this, FierdActivity::class.java)

            var startBytes = start_spn.selectedItemPosition
            var endBytes = end_spn.selectedItemPosition
            var result = digit_ed.text.toString().toLong()

            intent.putExtra("startBytes", startBytes)
            intent.putExtra("endBytes", endBytes)
            intent.putExtra("enteredDigit", result)

            if (startBytes > endBytes) {
                while (startBytes != endBytes) {
                    result *= 1024
                    startBytes -= 1
                }
            } else {
                while (startBytes != endBytes) {
                    result /= 1024
                    endBytes -= 1
                }
            }

            intent.putExtra("result", result)

            startActivity(intent)
        }
    }

}
