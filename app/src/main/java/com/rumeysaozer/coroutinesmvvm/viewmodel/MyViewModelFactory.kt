package com.rumeysaozer.coroutinesmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rumeysaozer.coroutinesmvvm.service.MainRepository

class MyViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(CompanyViewModel::class.java)){
            CompanyViewModel(this.repository) as T
        }else{
            throw IllegalAccessException("viewmodel not found")
        }
    }
}