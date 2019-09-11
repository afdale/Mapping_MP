package com.agneshandayani.mapping_mp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class Adapter: AppCompatActivity() {

    lateinit var submit: ImageButton

    private var listSIP1 = ArrayList<Container>()
    private lateinit var listSIP1Adapter: BaseAdapter

    private var listSIP2 = ArrayList<Container>()
    private lateinit var listSIP2Adapter: BaseAdapter

    private var listSIK1 = ArrayList<Container>()
    private lateinit var listSIK1Adapter: BaseAdapter

    private var listSIK2 = ArrayList<Container>()
    private lateinit var listSIK2Adapter: BaseAdapter

    var totalestimasi:Long? = null
    var waktu:Long? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onprogress_submit)



        try {
            val sip1ListView = findViewById<ListView>(R.id.alv)
            val sip2ListView = findViewById<ListView>(R.id.blv)
            val sik1ListView = findViewById<ListView>(R.id.clv)
            val sik2ListView = findViewById<ListView>(R.id.dlv)


            listSIP1Adapter = listSIP1Adapter(this, listSIP1)
            listSIP2Adapter = listSIP2Adapter(this, listSIP2)
            listSIK1Adapter = listSIK1Adapter (this, listSIK1)
            listSIK2Adapter = listSIK2Adapter(this, listSIK2)

            sip1ListView.adapter = listSIP1Adapter
            sip1ListView.setOnItemClickListener { parent, view, position, id ->
                val launch4 = Intent(this, BarcodeScannerActivity::class.java)
                launch4.putExtra("asal", "manpower")
                launch4.putExtra("op1", listSIP1[position].mop1)
                launch4.putExtra("op2", listSIP1[position].mop2)
                launch4.putExtra("op3", listSIP1[position].mop3)
                launch4.putExtra("op4", listSIP1[position].mop4)
                launch4.putExtra("op5", listSIP1[position].mop5)
                launch4.putExtra("mesin", listSIP1[position].mnomesin)
                launch4.putExtra("key", listSIP1[position].mKey)
                startActivity(launch4)
            }


            sip2ListView.adapter = listSIP2Adapter
            sip2ListView.setOnItemClickListener { parent, view, position, id ->
                val launch4 = Intent(this, BarcodeScannerActivity::class.java)
                launch4.putExtra("asal", "manpower")
                launch4.putExtra("op1", listSIP2[position].mop1)
                launch4.putExtra("op2", listSIP2[position].mop2)
                launch4.putExtra("op3", listSIP2[position].mop3)
                launch4.putExtra("op4", listSIP2[position].mop4)
                launch4.putExtra("op5", listSIP2[position].mop5)
                launch4.putExtra("mesin", listSIP2[position].mnomesin)
                launch4.putExtra("key", listSIP2[position].mKey)
                startActivity(launch4)
            }


            sik1ListView.adapter = listSIK1Adapter
            sik1ListView.setOnItemClickListener { parent, view, position, id ->
                val launch4 = Intent(this, BarcodeScannerActivity::class.java)
                launch4.putExtra("asal", "manpower")
                launch4.putExtra("op1", listSIK1[position].mop1)
                launch4.putExtra("op2", listSIK1[position].mop2)
                launch4.putExtra("op3", listSIK1[position].mop3)
                launch4.putExtra("op4", listSIK1[position].mop4)
                launch4.putExtra("op5", listSIK1[position].mop5)
                launch4.putExtra("mesin", listSIK1[position].mnomesin)
                launch4.putExtra("key", listSIK1[position].mKey)
                startActivity(launch4)
            }

            sik2ListView.adapter = listSIK2Adapter
            sik2ListView.setOnItemClickListener { parent, view, position, id ->
                val launch4 = Intent(this, BarcodeScannerActivity::class.java)
                launch4.putExtra("asal", "manpower")
                launch4.putExtra("op1", listSIP1[position].mop1)
                launch4.putExtra("op2", listSIP1[position].mop2)
                launch4.putExtra("op3", listSIP1[position].mop3)
                launch4.putExtra("op4", listSIP1[position].mop4)
                launch4.putExtra("op5", listSIP1[position].mop5)
                launch4.putExtra("mesin", listSIP1[position].mnomesin)
                launch4.putExtra("key", listSIP1[position].mKey)
                startActivity(launch4)
            }


        }catch (ex:Exception){
            Toast.makeText(this, "$ex", Toast.LENGTH_LONG).show()
        }
    }


    override fun onResume() {
        super.onResume()
        try {
            FirebaseDatabase.getInstance().getReference().child("mapping").child("manpower")
                .child("ABSENSIP1")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        listSIP1.clear()
                        try {
                            for (key in p0.children) {
                                val a = key.child("mesin").getValue(String::class.java)
                                val b = key.child("op1").getValue(String::class.java)
                                val c = key.child("op2").getValue(String::class.java)
                                val d = key.child("op3").getValue(String::class.java)
                                val e = key.child("op4").getValue(String::class.java)
                                val f = key.child("op5").getValue(String::class.java)
                                val g = key.child("key").getValue(String::class.java)

                                listSIP1.add(Container(a,b,c,d,e,f,g))

                                Log.i("Datasnapshot", "Datasnapshot : " + key.toString())
                                Log.i("kata f ", f.toString())
                                Log.i("kata k ", g.toString())
                                Log.i("kata a ", a)
                            }
                            listSIP1Adapter.notifyDataSetChanged()

                        } catch (ex: Exception) {
                            Log.i("ERRORMSG", "error : " + ex.toString())
                        }
                    }

                })

            FirebaseDatabase.getInstance().getReference().child("mapping").child("manpower")
                .child("ABSENSIP2")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        listSIP2.clear()
                        try {
                            for (key in p0.children) {
                                val a = key.child("mesin").getValue(String::class.java)
                                val b = key.child("op1").getValue(String::class.java)
                                val c = key.child("op2").getValue(String::class.java)
                                val d = key.child("op3").getValue(String::class.java)
                                val e = key.child("op4").getValue(String::class.java)
                                val f = key.child("op5").getValue(String::class.java)
                                val g = key.child("key").getValue(String::class.java)

                                listSIP2.add(Container(a,b,c,d,e,f,g))

                                Log.i("Datasnapshot", "Datasnapshot : " + key.toString())
                                Log.i("kata f ", f.toString())
                                Log.i("kata k ", g.toString())
                                Log.i("kata a ", a)
                            }
                            listSIP2Adapter.notifyDataSetChanged()

                        } catch (ex: Exception) {
                            Log.i("ERRORMSG", "error : " + ex.toString())
                        }
                    }

                })

            FirebaseDatabase.getInstance().getReference().child("mapping").child("manpower")
                .child("ABSENSIK1")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        listSIK1.clear()
                        try {
                            for (key in p0.children) {
                                val a = key.child("mesin").getValue(String::class.java)
                                val b = key.child("op1").getValue(String::class.java)
                                val c = key.child("op2").getValue(String::class.java)
                                val d = key.child("op3").getValue(String::class.java)
                                val e = key.child("op4").getValue(String::class.java)
                                val f = key.child("op5").getValue(String::class.java)
                                val g = key.child("key").getValue(String::class.java)

                                listSIK1.add(Container(a,b,c,d,e,f,g))

                                Log.i("Datasnapshot", "Datasnapshot : " + key.toString())
                                Log.i("kata f ", f.toString())
                                Log.i("kata k ", g.toString())
                                Log.i("kata a ", a)
                            }
                            listSIK1Adapter.notifyDataSetChanged()

                        } catch (ex: Exception) {
                            Log.i("ERRORMSG", "error : " + ex.toString())
                        }
                    }

                })

            FirebaseDatabase.getInstance().getReference().child("mapping").child("manpower")
                .child("ABSENSIK2")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        listSIK2.clear()
                        try {
                            for (key in p0.children) {
                                val a = key.child("mesin").getValue(String::class.java)
                                val b = key.child("op1").getValue(String::class.java)
                                val c = key.child("op2").getValue(String::class.java)
                                val d = key.child("op3").getValue(String::class.java)
                                val e = key.child("op4").getValue(String::class.java)
                                val f = key.child("op5").getValue(String::class.java)
                                val g = key.child("key").getValue(String::class.java)

                                listSIK2.add(Container(a,b,c,d,e,f,g))

                                Log.i("Datasnapshot", "Datasnapshot : " + key.toString())
                                Log.i("kata f ", f.toString())
                                Log.i("kata k ", g.toString())
                                Log.i("kata a ", a)
                            }
                            listSIK2Adapter.notifyDataSetChanged()

                        } catch (ex: Exception) {
                            Log.i("ERRORMSG", "error : " + ex.toString())
                        }
                    }

                })


        } catch (ez:Exception){
            Toast.makeText(this, "$ez", Toast.LENGTH_LONG).show()
        }
    }


    inner class listSIP1Adapter : BaseAdapter {

        private var listSIP1 = ArrayList<Container>()
        private var context: Context? = null

        constructor(context: Context, listSIP1: ArrayList<Container>) : super() {
            this.listSIP1 = listSIP1
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val view: View
            val vh: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.analisa_adapter, parent, false)
                vh = ViewHolder(view)
                view.tag = vh
                Log.i("PC", "set Tag for ViewHolder, position: " + position)
            } else {
                view = convertView
                vh = view.tag as ViewHolder
            }



            /*   displaypProgressBar.setMax(100)[position]
               displaypProgressBar.setProgress(20)*/
            try {

                vh.nomesintv.text = listSIP1[position].mnomesin
                vh.keteranganTV.text = listSIP1[position].mop1/*
                vh.estimasijam.text = listProblemOnprogress[position].mestimasijam.toString()
                vh.estimasimenit.text = listProblemOnprogress[position].mestimasimenit.toString()*/



                val selisihgmt:Long = System.currentTimeMillis() - SystemClock.elapsedRealtime()
                waktu = totalestimasi!! - selisihgmt


                Log.i("time","waktu : "+waktu!!.toString())
                Log.i("time","system millis : "+System.currentTimeMillis().toString())
                Log.i("time","system clock : "+ SystemClock.elapsedRealtime().toString())

            }catch (ex2:java.lang.Exception){
                Log.i("error data","$ex2")
            }



            return view
        }

        override fun getItem(position: Int): Any {

            return listSIP1[position]
        }

        override fun getItemId(position: Int): Long {

            return position.toLong()
        }

        override fun getCount(): Int {

            return listSIP1.size
        }

    }


    inner class listSIP2Adapter : BaseAdapter {

        private var listSIP2 = ArrayList<Container>()
        private var context: Context? = null

        constructor(context: Context, listSIP2: ArrayList<Container>) : super() {
            this.listSIP2 = listSIP2
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val view: View
            val vh: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.analisa_adapter, parent, false)
                vh = ViewHolder(view)
                view.tag = vh
                Log.i("PC", "set Tag for ViewHolder, position: " + position)
            } else {
                view = convertView
                vh = view.tag as ViewHolder
            }



            /*   displaypProgressBar.setMax(100)[position]
               displaypProgressBar.setProgress(20)*/
            try {

                vh.nomesintv.text = listSIP2[position].mnomesin
                vh.keteranganTV.text = listSIP2[position].mop1/*
                vh.estimasijam.text = listProblemOnprogress[position].mestimasijam.toString()
                vh.estimasimenit.text = listProblemOnprogress[position].mestimasimenit.toString()*/



                val selisihgmt:Long = System.currentTimeMillis() - SystemClock.elapsedRealtime()
                waktu = totalestimasi!! - selisihgmt


                Log.i("time","waktu : "+waktu!!.toString())
                Log.i("time","system millis : "+System.currentTimeMillis().toString())
                Log.i("time","system clock : "+ SystemClock.elapsedRealtime().toString())

            }catch (ex2:java.lang.Exception){
                Log.i("error data","$ex2")
            }



            return view
        }

        override fun getItem(position: Int): Any {

            return listSIP2[position]
        }

        override fun getItemId(position: Int): Long {

            return position.toLong()
        }

        override fun getCount(): Int {

            return listSIP2.size
        }

    }



    inner class listSIK1Adapter : BaseAdapter {

        private var listSIK1 = ArrayList<Container>()
        private var context: Context? = null

        constructor(context: Context, listSIK1: ArrayList<Container>) : super() {
            this.listSIK1 = listSIK1
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val view: View
            val vh: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.analisa_adapter, parent, false)
                vh = ViewHolder(view)
                view.tag = vh
                Log.i("PC", "set Tag for ViewHolder, position: " + position)
            } else {
                view = convertView
                vh = view.tag as ViewHolder
            }



            /*   displaypProgressBar.setMax(100)[position]
               displaypProgressBar.setProgress(20)*/
            try {

                vh.nomesintv.text = listSIK1[position].mnomesin
                vh.keteranganTV.text = listSIK1[position].mop1/*
                vh.estimasijam.text = listProblemOnprogress[position].mestimasijam.toString()
                vh.estimasimenit.text = listProblemOnprogress[position].mestimasimenit.toString()*/



                val selisihgmt:Long = System.currentTimeMillis() - SystemClock.elapsedRealtime()
                waktu = totalestimasi!! - selisihgmt


                Log.i("time","waktu : "+waktu!!.toString())
                Log.i("time","system millis : "+System.currentTimeMillis().toString())
                Log.i("time","system clock : "+ SystemClock.elapsedRealtime().toString())

            }catch (ex2:java.lang.Exception){
                Log.i("error data","$ex2")
            }



            return view
        }

        override fun getItem(position: Int): Any {

            return listSIK1[position]
        }

        override fun getItemId(position: Int): Long {

            return position.toLong()
        }

        override fun getCount(): Int {

            return listSIK1.size
        }

    }

    inner class listSIK2Adapter : BaseAdapter {

        private var listSIK2 = ArrayList<Container>()
        private var context: Context? = null

        constructor(context: Context, listSIK2: ArrayList<Container>) : super() {
            this.listSIK2 = listSIK2
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val view: View
            val vh: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.analisa_adapter, parent, false)
                vh = ViewHolder(view)
                view.tag = vh
                Log.i("PC", "set Tag for ViewHolder, position: " + position)
            } else {
                view = convertView
                vh = view.tag as ViewHolder
            }



            /*   displaypProgressBar.setMax(100)[position]
               displaypProgressBar.setProgress(20)*/
            try {

                vh.nomesintv.text = listSIK2[position].mnomesin
                vh.keteranganTV.text = listSIK2[position].mop1/*
                vh.estimasijam.text = listProblemOnprogress[position].mestimasijam.toString()
                vh.estimasimenit.text = listProblemOnprogress[position].mestimasimenit.toString()*/



                val selisihgmt:Long = System.currentTimeMillis() - SystemClock.elapsedRealtime()
                waktu = totalestimasi!! - selisihgmt


                Log.i("time","waktu : "+waktu!!.toString())
                Log.i("time","system millis : "+System.currentTimeMillis().toString())
                Log.i("time","system clock : "+ SystemClock.elapsedRealtime().toString())

            }catch (ex2:java.lang.Exception){
                Log.i("error data","$ex2")
            }



            return view
        }

        override fun getItem(position: Int): Any {

            return listSIK2[position]
        }

        override fun getItemId(position: Int): Long {

            return position.toLong()
        }

        override fun getCount(): Int {

            return listSIK2.size
        }

    }

    private class ViewHolder(view: View?) {
        val nomesintv: TextView
        val keteranganTV: TextView
        val hitungTV: Chronometer
        val estimasijam : TextView
        val estimasimenit : TextView

        init {
            this.nomesintv = view?.findViewById<TextView>(R.id.nomesinTV) as TextView
            this.keteranganTV = view.findViewById<TextView>(R.id.keteranganTV) as TextView
            this.hitungTV = view.findViewById<Chronometer>(R.id.hitungTV) as Chronometer
            this.estimasijam = view.findViewById<TextView>(R.id.estimasijam) as TextView
            this.estimasimenit = view.findViewById<TextView>(R.id.estimasimenit) as TextView
        }
    }

}