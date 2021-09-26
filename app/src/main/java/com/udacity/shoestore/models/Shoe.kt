package com.udacity.shoestore.models

import android.os.Parcelable
import android.widget.EditText
import androidx.databinding.InverseMethod
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String = "", var size: Double = 0.0, var company: String = "", var description: String = "",
                val images: List<String> = mutableListOf()) : Parcelable


