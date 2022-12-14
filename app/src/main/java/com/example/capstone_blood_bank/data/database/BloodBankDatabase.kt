package com.example.capstone_blood_bank.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.capstone_blood_bank.data.dao.BloodBankDao
import com.example.capstone_blood_bank.data.responses.BloodBankResponses

@Database(entities = [BloodBankResponses::class], version = 1, exportSchema = false)
abstract class BloodBankDatabase : RoomDatabase() {
    abstract fun bloodBankDao(): BloodBankDao
}