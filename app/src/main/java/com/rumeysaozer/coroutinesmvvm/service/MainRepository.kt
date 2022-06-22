package com.rumeysaozer.coroutinesmvvm.service

class MainRepository constructor(private val companyService: CompanyService) {
    suspend fun getAllCompanies() = companyService.getCompany()
}