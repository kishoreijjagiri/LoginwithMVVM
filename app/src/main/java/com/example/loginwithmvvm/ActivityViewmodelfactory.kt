package com.example.loginwithmvvm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ActivityViewmodelfactory(val applicationContext: Context) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return ActivityViewModel(applicationContext) as T
    }

}