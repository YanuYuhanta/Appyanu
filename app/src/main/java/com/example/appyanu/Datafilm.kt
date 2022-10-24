package com.example.appyanu

import android.os.Parcel
import android.os.Parcelable

/*classs dibawah memiliki parameter yang digunakan sebagai model.
* terdapat kode program Parcelable digunakan untuk mengirim data sekaligus dan dapat mengirim data
* dengan tipe data yang berbeda beda.*/
data class Datafilm(val imageFilm: Int, val txtView: String, val descView: String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageFilm)
        parcel.writeString(txtView)
        parcel.writeString(descView)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Datafilm> {
        override fun createFromParcel(parcel: Parcel): Datafilm {
            return Datafilm(parcel)
        }

        override fun newArray(size: Int): Array<Datafilm?> {
            return arrayOfNulls(size)
        }
    }

}