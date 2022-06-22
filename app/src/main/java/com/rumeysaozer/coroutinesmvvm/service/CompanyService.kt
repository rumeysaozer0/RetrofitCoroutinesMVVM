package com.rumeysaozer.coroutinesmvvm.service

import com.rumeysaozer.coroutinesmvvm.model.Company
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CompanyService {
    @GET("company/random_company?size=20")
    suspend fun getCompany():Response<Company>

    companion object{
        var companyService : CompanyService? = null
        fun getInstance(): CompanyService{
            if(companyService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://random-data-api.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                companyService = retrofit.create(CompanyService::class.java)
            }
            return companyService!!
        }

    }
}