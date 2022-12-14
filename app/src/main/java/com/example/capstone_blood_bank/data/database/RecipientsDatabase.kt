package com.example.capstone_blood_bank.data.database

import android.content.Context
import androidx.room.Room

class RecipientsDatabase private constructor(context: Context) {
    var bloodBankDatabase: BloodBankDatabase

    companion object {
        private var mInstance: RecipientsDatabase? = null

        fun getInstance(context: Context): RecipientsDatabase? {
            if (mInstance == null) {
                mInstance = RecipientsDatabase(context)
            }
            return mInstance
        }
    }

    init {
        bloodBankDatabase =
            Room.databaseBuilder(context, BloodBankDatabase::class.java, "wastebank_db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
