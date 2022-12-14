package com.example.capstone_blood_bank.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.capstone_blood_bank.data.dao.BloodBankDao
import com.example.capstone_blood_bank.data.database.RecipientsDatabase.Companion.getInstance
import com.example.capstone_blood_bank.data.responses.BloodBankResponses
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class RecipientHistoryViewModel(application: Application) : AndroidViewModel(application) {

    var dataBank: LiveData<List<BloodBankResponses>>
    private var bloodBankDao: BloodBankDao? = null

    fun deleteDataById(uid: Int) {
        Completable.fromAction {
            bloodBankDao?.deleteSingleData(uid)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        bloodBankDao = getInstance(application)?.bloodBankDatabase?.bloodBankDao()
        dataBank = bloodBankDao?.getAll()!!
    }

}