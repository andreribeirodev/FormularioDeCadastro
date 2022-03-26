package com.example.formulariodecadastroalura.model

import android.os.Parcel
import android.os.Parcelable


data class Address(
    val cep: String?,
    val logradouro: String?,
    val numero: String?,
    val bairro: String?,
    val complemento: String?,
    val cidade: String?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cep)
        parcel.writeString(logradouro)
        parcel.writeString(numero)
        parcel.writeString(bairro)
        parcel.writeString(complemento)
        parcel.writeString(cidade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }

}
