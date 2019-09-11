package com.agneshandayani.mapping_mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var ref: DatabaseReference

    private lateinit var kunci: String
    private var valueshift: Int= 0
    private var tanggal: String? = null

    private lateinit var radiogroup: RadioGroup
    private lateinit var radioshift1: RadioButton
    private lateinit var radioshift2: RadioButton
    private lateinit var radioshift3: RadioButton

    private lateinit var startButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //kunci = getIntent().getStringExtra("key")
/*

        radiogroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioshift1 = findViewById<RadioButton>(R.id.radioShift1)
        radioshift2 = findViewById<RadioButton>(R.id.radioShift2)
        radioshift3 = findViewById<RadioButton>(R.id.radioShift3)
*/

        ref = FirebaseDatabase.getInstance().getReference().child("mapping").child("manpower")
            .child("SHIFT")

        try {
            startButton = findViewById(R.id.btnStart)
            startButton.setOnClickListener {
                // Toast.makeText(this, "${radiogroup.checkedRadioButtonId}", Toast.LENGTH_LONG).show()
               /* if (radiogroup.checkedRadioButtonId == 2131230854) {
                    valueshift = 1
                } else if (radiogroup.checkedRadioButtonId == 2131230855) {
                    valueshift = 2
                } else if (radiogroup.checkedRadioButtonId == 2131230856) {
                    valueshift = 3
                }
                savedata()
                Toast.makeText(this, "${valueshift}", Toast.LENGTH_LONG).show()
                */

                startActivity(Intent(this, FormSubmit::class.java))
                finish()
            }
        } catch (ex: Exception) {
            Toast.makeText(this, "$ex", Toast.LENGTH_LONG).show()
        }
    }
        /*private fun savedata() {
            try {
                ref.child(kunci!!).child("valueshift").setValue(valueshift)
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            } catch (ex: Exception) {
                Toast.makeText(this, "$ex", Toast.LENGTH_LONG).show()
            }
        }*/
    }