package com.example.kalkuarfan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var bilSatu: EditText
    private lateinit var bilDua: EditText
    private lateinit var kali: Button
    private lateinit var bagi: Button
    private lateinit var tambah: Button
    private lateinit var kurang: Button
    private lateinit var hasil: TextView
    private lateinit var hapus: Button
    private lateinit var simpan: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bilSatu = findViewById(R.id.et_bilangan_pertama)
        bilDua = findViewById(R.id.et_bilangan_kedua)
        kali = findViewById(R.id.button_kali)
        bagi = findViewById(R.id.button_bagi)
        tambah = findViewById(R.id.button_plus)
        kurang = findViewById(R.id.button_minus)
        hasil = findViewById(R.id.tv_hasil)
        simpan = findViewById(R.id.btn_SIMPAN)
        recyclerView = findViewById(R.id.Rv_Hasil)

        val data = mutableListOf<DataKalku>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = AdapterKalku(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        kali.setOnClickListener { kali () }
        bagi.setOnClickListener { bagi () }
        tambah.setOnClickListener { plus () }
        kurang.setOnClickListener { kurang () }

        simpan.setOnClickListener {
            val satu = bilSatu.text.toString()
            val dua = bilDua.text.toString()
            val hasil = hasil.text.toString()

            val dataMTK = DataKalku(satu, dua,hasil)
            data.add(dataMTK)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
    fun plus(){
        val hitung = bilSatu.text.toString().toDouble() + bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun kurang(){
        val hitung = bilSatu.text.toString().toDouble() - bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun bagi(){
        val hitung = bilSatu.text.toString().toDouble() / bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun kali(){
        val hitung = bilSatu.text.toString().toDouble() * bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }

}