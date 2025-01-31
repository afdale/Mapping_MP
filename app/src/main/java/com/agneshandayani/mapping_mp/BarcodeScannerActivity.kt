package com.agneshandayani.mapping_mp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class BarcodeScannerActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private var mScannerView: ZXingScannerView? = null

    //lateinit var connectionClass: ConnectionClass
     var asal: String? = null
    lateinit var tulisanTVNEW: TextView
    lateinit var msgTV:TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        mScannerView = ZXingScannerView(this)

        setContentView(mScannerView)*/
        setContentView(R.layout.activity_barcode_scanner)
        mScannerView = findViewById<ZXingScannerView>(R.id.scanner)
        asal = intent.getStringExtra("asal")
        //asal = getIntent().getStringExtra("asal")

        tulisanTVNEW = findViewById<TextView>(R.id.tulisanTVNEW)
        msgTV = findViewById<TextView>(R.id.msgTV)

        if ((asal=="mesin")){
            tulisanTVNEW.text = "Scan QR CODE pada MESIN untuk menyelesaikan"
        }
        else if ((asal!!.contains("ID", false))){
            tulisanTVNEW.text = "Scan QR CODE pada TAGID untuk menyelesaikan"
        }

    }

    public override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this)
        mScannerView!!.startCamera()
    }

    public override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera()
    }

    override fun handleResult(rawResult: Result) {
        Log.v("TAG", rawResult.getText()) // Prints scan results
        Log.v("TAG", rawResult.getBarcodeFormat().toString())


        if ((asal == "mesin")&&rawResult.getText().contains("MC",false))  {
            val launch = Intent()
            launch.putExtra("mesin", rawResult.getText())
            setResult(RESULT_OK, launch)
            finish()
        }
        else if ((asal == "op1")&&rawResult.getText().contains("ID",false)) {
            val launch = Intent()
            launch.putExtra("operator1", rawResult.getText())
            setResult(RESULT_OK, launch)
            finish()
        }
        else if ((asal == "op2")&&rawResult.getText().contains("ID",false)) {

            val launch = Intent()
            launch.putExtra("operator2", rawResult.getText())
            setResult(RESULT_OK, launch)
            finish()
        }
        else if ((asal == "op3")&&rawResult.getText().contains("ID",false)) {
            val launch = Intent()
            launch.putExtra("operator3", rawResult.getText())
            setResult(RESULT_OK, launch)
            finish()
        }
        else if ((asal == "op4")&&rawResult.getText().contains("ID",false)) {
            val launch = Intent()
            launch.putExtra("operator4", rawResult.getText())
            setResult(RESULT_OK, launch)
            finish()
        }
        else if ((asal == "op5")&&rawResult.getText().contains("ID",false)) {
            val launch = Intent()
            launch.putExtra("operator5", rawResult.getText())
            setResult(RESULT_OK, launch)
            finish()
        }

        else if(asal!!.contains("ID",false)) {
            msgTV.text = "QR Code yang anda scan salah, scan QR Code pada ID CARD"
        }

        else
        {
            mScannerView!!.resumeCameraPreview(this)
        }
    }
}