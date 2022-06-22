package com.rumeysaozer.coroutinesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rumeysaozer.coroutinesmvvm.model.Company
import com.rumeysaozer.coroutinesmvvm.service.MainRepository
import kotlinx.coroutines.*


class CompanyViewModel (private val mainRepository: MainRepository) : ViewModel(){
    val companyList = MutableLiveData<Company>()
    var job: Job? = null
    fun getData(){
        job = CoroutineScope(Dispatchers.IO ).launch {
            val response = mainRepository.getAllCompanies()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    companyList.postValue(response.body())
                }else{

                }
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}