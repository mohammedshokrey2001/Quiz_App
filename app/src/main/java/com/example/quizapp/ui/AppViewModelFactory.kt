package com.example.quizapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class AppViewModelFactory(val app: Application) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {

        if (modelClass.isAssignableFrom(AppViewModel::class.java)){
            return AppViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct view-model ")

    }
}