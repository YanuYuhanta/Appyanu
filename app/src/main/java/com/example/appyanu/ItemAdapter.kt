package com.example.appyanu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*class ItemAdapter akan mengatur jumlah list data yang ditampilkan sehingga tidak memenuhi memory karena
* sebagian data disimpan pada adapter.
* ItemAdapter juga berfungsi untuk membuat object baru dari ViewHolder dengan mngisikan data dan mengembalikan*/
class ItemAdapter(private val data:ArrayList<Datafilm>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    var btnClick : ((Datafilm) -> Unit)? = null

    /*
    * class itemviewholder akan memperkenalkan item seperti gambar dan string
    * serta akan mencari tempat untuk data ditampilkan*/
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgFilm: ImageView = itemView.findViewById(R.id.img_item)
        val txtTitle: TextView = itemView.findViewById(R.id.item_title)
        val btnButton: Button = itemView.findViewById(R.id.item_button)
    }

    /*
    * pada method dibawah akan menentukan lokasi dimana viewholder akan ditampilkan
    * R.layout.list_item merupakan lokasi komponen ItemViewHolder akan ditampilkan*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view )
    }

    /*
    * pada kode dibawah akan membuat sebuah value yang mendefinisikan property termasuk diatas arraylist*/
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val datafilm = data[position]
        /*kode program holder akan mengambil data dari arraylist yang sudah diinputkan di MainCtivity
        * pada holder button terdapat action setOnClickListener yang jika button diklik akan bereaksi sesuai kode yang didefinisikan
        * variabel btnClick akan dimasukan sebagai reaksi dari button yang akan */
        holder.imgFilm.setImageResource(datafilm.imageFilm)
        holder.txtTitle.text = datafilm.txtView
        holder.btnButton.setOnClickListener{
            btnClick?.invoke(datafilm)
        }
    }

    /*
    * method getIntemCount akan mengembalikan nilai data yang sudah dipanggil oleh method onBindViewHolder*/
    override fun getItemCount(): Int {
        return data.size
    }


}
