package com.agneshandayani.mapping_mp

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_form_submit.*

class FormUpdateIstirahatKedua : AppCompatActivity() {

    lateinit var ref: DatabaseReference
    lateinit var connectionClass: ConnectionClass

    private var btnmc: ImageButton? = null
    private var btnop1: ImageButton? = null
    private var btnop2: ImageButton? = null
    private var btnop3: ImageButton? = null
    private var btnop4: ImageButton? = null
    private var btnop5: ImageButton? = null

    //keterangan:button scanner di form_submit

    private var btnfinish: ImageButton? = null


    lateinit var nomesin: TextView
    lateinit var operator1: TextView
    lateinit var operator2: TextView
    lateinit var operator3: TextView
    lateinit var operator4: TextView
    lateinit var operator5: TextView

    lateinit var asal: String
    private var kunci: String? = null
    private var valueshift: Int= 0

    var mesin: String? = "N/A"
    var op1: String? = "N/A"
    var op2: String? = "N/A"
    var op3: String? = "N/A"
    var op4: String? = "N/A"
    var op5: String? = "N/A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_update)

        ref = FirebaseDatabase.getInstance().getReference().child("mapping").child("manpower")
            .child("ABSENSIK2")
        kunci = getIntent().getStringExtra("key")

        btnfinish = findViewById<ImageButton>(R.id.btnFinish)
        btnmc = findViewById<ImageButton>(R.id.scanmc)
        btnop1 = findViewById<ImageButton>(R.id.scanop1)
        btnop2 = findViewById<ImageButton>(R.id.scanop2)
        btnop3 = findViewById<ImageButton>(R.id.scanop3)
        btnop4 = findViewById<ImageButton>(R.id.scanop4)
        btnop5 = findViewById<ImageButton>(R.id.scanop5)

        nomesin = findViewById<TextView>(R.id.nomesin)
        operator1 = findViewById<TextView>(R.id.no_op1)
        operator2 = findViewById<TextView>(R.id.no_op2)
        operator3 = findViewById<TextView>(R.id.no_op3)
        operator4 = findViewById<TextView>(R.id.no_op4)
        operator5 = findViewById<TextView>(R.id.no_op5)

        nomesin.text = mesin
        operator1.text = op1
        operator2.text = op2
        operator3.text = op3
        operator4.text = op4
        operator5.text = op5

        btnmc!!.setOnClickListener {
            val intent = Intent(this@FormUpdateIstirahatKedua, BarcodeScannerActivity::class.java)
            intent.putExtra("asal", "mesin")
            startActivityForResult(intent, 1)
        }
        btnop1!!.setOnClickListener {
            val intent = Intent(this@FormUpdateIstirahatKedua, BarcodeScannerActivity::class.java)
            intent.putExtra("asal", "op1")
            startActivityForResult(intent, 2)
        }
        btnop2!!.setOnClickListener {
            val intent = Intent(this@FormUpdateIstirahatKedua, BarcodeScannerActivity::class.java)
            intent.putExtra("asal", "op2")
            startActivityForResult(intent, 3)
        }
        btnop3!!.setOnClickListener {
            val intent = Intent(this@FormUpdateIstirahatKedua, BarcodeScannerActivity::class.java)
            intent.putExtra("asal", "op3")
            startActivityForResult(intent, 4)
        }
        btnop4!!.setOnClickListener {
            val intent = Intent(this@FormUpdateIstirahatKedua, BarcodeScannerActivity::class.java)
            intent.putExtra("asal", "op4")
            startActivityForResult(intent, 5)
        }
        btnop5!!.setOnClickListener {
            val intent = Intent(this@FormUpdateIstirahatKedua, BarcodeScannerActivity::class.java)
            intent.putExtra("asal", "op5")
            startActivityForResult(intent, 6)
        }
        btnFinish.setOnClickListener {

            savedata()
            val intent = Intent(this, Adapter::class.java)
            startActivity(intent)
        }

    }

    private fun savedata() {
        try {
            val mesin = nomesin.text.toString()
            val operator1 = no_op1.text.toString()
            val operator2 = no_op2.text.toString()
            val operator3 = no_op3.text.toString()
            val operator4 = no_op4.text.toString()
            val operator5 = no_op5.text.toString()

            val mesinId = ref.push().key.toString()

            ref.child(mesinId).child("key").setValue(mesinId)
            ref.child(mesinId).child("mesin").setValue(mesin)
            ref.child(mesinId).child("op1").setValue(operator1)
            ref.child(mesinId).child("op2").setValue(operator2)
            ref.child(mesinId).child("op3").setValue(operator3)
            ref.child(mesinId).child("op4").setValue(operator4)
            ref.child(mesinId).child("op5").setValue(operator5)
            ref.child(mesinId).child("valueshift").setValue(valueshift)

            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

            nomesin.setText("")
            no_op1.setText("")
            no_op2.setText("")
            no_op3.setText("")
            no_op4.setText("")
            no_op4.setText("")
            no_op5.setText("")


        } catch (ex: Exception) {
            Toast.makeText(this, "$ex", Toast.LENGTH_LONG).show()
        }

    }

    override fun onResume() {
        super.onResume()
        nomesin.text = mesin
        operator1.text = op1
        operator2.text = op2
        operator3.text = op3
        operator4.text = op4
        operator5.text = op5
    }

    fun mesin(): String? {
        return mesin
    }

    fun operator1(): String? {
        return op1
    }

    fun operator2(): String? {
        return op2
    }

    fun operator3(): String? {
        return op3
    }

    fun operator4(): String? {
        return op4
    }

    fun DoUpload() {
        val launch4 = Intent(this, BarcodeScannerActivity::class.java)
        launch4.putExtra("asal", asal)
        try {
            startActivity(launch4)
        } catch (ex: Exception) {
            Toast.makeText(this, "$ex", Toast.LENGTH_LONG).show()
        }
    }

    fun DoResult(code: Int) {
        val launch4 = Intent(this, BarcodeScannerActivity::class.java)
        launch4.putExtra("asal", asal)
        try {
            startActivityForResult(launch4, code)
        } catch (ex: Exception) {
            Toast.makeText(this, "$ex", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                mesin = data!!.getStringExtra("mesin")
            }
        }
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                op1 = data!!.getStringExtra("operator1")
            }
        }
        if (requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                op2 = data!!.getStringExtra("operator2")
            }
        }
        if (requestCode == 4) {
            if (resultCode == Activity.RESULT_OK) {
                op3 = data!!.getStringExtra("operator3")
            }
        }
        if (requestCode == 5) {
            if (resultCode == Activity.RESULT_OK) {
                op4 = data!!.getStringExtra("operator4")
            }
        }
        if (requestCode == 6) {
            if (resultCode == Activity.RESULT_OK) {
                op5 = data!!.getStringExtra("operator5")
            }
        }
    }



    inner class Douploadreport(var activity: FormUpdate) : AsyncTask<String, String, String>() {
        var dialog = Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar)
        private var z = ""
        internal var isSuccess = false

        override fun onPreExecute() {
            val view = activity.layoutInflater.inflate(R.layout.progress, null)
            dialog.setContentView(view)
            dialog.setCancelable(false)
            dialog.show()

        }

        override fun doInBackground(vararg params: String): String {
            try {
                val con = connectionClass.CONN()

                if (con == null) {
                    z = "Please check your internet connection"
                } else {
                    val query =
                        "INSERT INTO skillmapping (nomesin,operator1,operator2,operator3,operator4,operator5) VALUES ('$mesin','$op1','$op2','$op3','$op4','$op5')"
                    val stmt = con.createStatement()
                    stmt.executeUpdate(query)
                    z = "Upload successfull"
                    isSuccess = true
                }
            } catch (ex: Exception) {
                isSuccess = false
                z = "ERROR : $ex"
            }
            return z
        }

        override fun onPostExecute(s: String) {
            dialog.dismiss()
            Toast.makeText(this@FormUpdateIstirahatKedua, "" + z, Toast.LENGTH_LONG).show()

            if (isSuccess) {
                FirebaseDatabase.getInstance().getReference().child("mapping").child("manpower")
                    .child("ABSENSIK1").removeValue()
                this@FormUpdateIstirahatKedua.finish()
            }
        }
    }
    fun goCancelProgress(view: View) {
        finish()
    }

}
