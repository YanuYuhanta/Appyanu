package com.example.appyanu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    /*
    * kode lateinit var akan membuat dan mendefinisikan sebuah variabel
    * serta akan langsung diinisialisasikan seperti filmAdapter akan diinisialisasi dengan class ItemAdapter*/
    lateinit var recyclerView: RecyclerView
    lateinit var filmAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * kode findViewById akan mendefinisikan lokasi dimana listdata akan ditampilkan dengan mendeklarasikan id dari recyclerview.
        * setHasFixedSize didgunakan untuk memastikan ukuran recyclerView ini konstan sehingga ketika data masuk
        * ukuran dan lebar view tidak akan berubah.
        * LayoutManager akan mengatur view RecyclerView agar ditampilkan secara linear*/
        recyclerView = findViewById(R.id.recycle_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        /*
        * kode program dibawah akan membuat variabel data dan terdapat array yang akan
        * memamnggil parameter model sehingga data gambar dan string dapat dimasukkan seperti dibawah*/
        var data = ArrayList<Datafilm>()
        data.add(Datafilm(R.drawable.sanandreas,"San Andreas",
            "Ray, seorang pilot helikopter penyelamat harus berpacu dengan " +
                    "waktu untuk menyelematkan anak dan istrinya dari bencana alam dahsyat."))
        data.add(Datafilm(R.drawable.jurrasicpark,"Jurassic Park",
            "Sebuah wahana taman hiburan dengan sejumlah makhluk dinosaurus-kloningan berubah " +
                    "menjadi teror mengerikan ketika badai melanda menghancurkan area taman dan semua dinosaurus mulai lepas dari kandang."))
        data.add(Datafilm(R.drawable.hunterkiller,"Hunter Killer",
            "Hunter Killer akan berkisah tentang misi tim kapal selam Amerika Serikat untuk " +
                    "menyelamatkan presiden Rusia yang di kudeta oleh kelompok militan di negaranya."))
        data.add(Datafilm(R.drawable.avatar,"Avatar",
            "Seorang Marinir lumpuh dikirim ke bulan Pandora untuk menjalani misi khusus namun, " +
                    "ia justru dilema antara mengikuti perintah atau melindungi dunia baru yang iya rasakan seperti rumah."))
        data.add(Datafilm(R.drawable.battleship,"BattleShip",
            "Armada Angkatan Laut internasional menjadi basis pertahanan terakhir ketika spesies asing yang disebut " +
                    "The Regents mencoba menyerang Bumi Terperangkap di tengah serangan mahkluk asing, Letnan Alex Hopper " +
                    "harus bekerjasama dengan saudaranya, Stone dan ayah tunangannya, Laksamana Shane, untuk membantu" +
                    " tim mengusir para penyerbu sebelum terlambat."))
        data.add(Datafilm(R.drawable.drstrage,"Doctor Strange",
            "Dr. Stephen Strange mengalami sebuah kecelakaan yang fatal yang merusak kemampuan motorik kedua tangannya." +
                    "Demi kesembuhannya, ia mengunjungi seorang penyihir misterius bernama Ancient One di Tibet."))

        /*kode program dibawah akan mempassing data dari ItemAdapter agar tampil sesuai recycleView*/
        filmAdapter = ItemAdapter(data)
        recyclerView.adapter = filmAdapter

        /*filmAdapter akan mengambil value btnclick dari ItemAdapter dan akan membaut intent untuk pindah ke DetailActivity
        * Intent akan mendefinisikan package MainActivity dan akan pindah ke DetailActivity jika button diclick
        * putExtra berfungsi untuk mengirim data dari MainActivty ke DetailActivity datafilm sebagai namanya dan it untuk semua data yang ada
        * startActivity berfungsi untuk menjalankan intent agar dapat berpindah.*/
        filmAdapter.btnClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("datafilm", it)
            startActivity(intent)
        }

    }
}