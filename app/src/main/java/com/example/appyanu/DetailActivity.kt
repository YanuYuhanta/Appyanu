package com.example.appyanu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

import android.widget.TextView
import org.w3c.dom.Text


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        /* value film akan mengumpulkan data yang dikirim variabel datafilm yang berada di MainActivity*/
        val film = intent.getParcelableExtra<Datafilm>("datafilm")
        if(film != null){
            /*kode program dibawah akan menentukan dimana letak data akan ditampilkan*/
            val txtTitle: TextView = findViewById(R.id.item_title)
            val imgView: ImageView = findViewById(R.id.item_image)
            val descView: TextView = findViewById(R.id.item_desc)

            /*kode program dibawah akan mendefinisikan tipe data dan dimana data diambil.*/
            txtTitle.text = film.txtView
            imgView.setImageResource(film.imageFilm)
            descView.text = film.descView
        }
    }
}