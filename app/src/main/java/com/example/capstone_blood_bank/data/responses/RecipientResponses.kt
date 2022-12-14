package com.example.capstone_blood_bank.data.responses

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipientResponses(
    var email: String? = "",
    var name: String? = "",
    var password: String? = "",
    var url: String? = "",
) : Parcelable
