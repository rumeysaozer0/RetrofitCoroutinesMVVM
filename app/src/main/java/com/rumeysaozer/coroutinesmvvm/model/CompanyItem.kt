package com.rumeysaozer.coroutinesmvvm.model


import com.google.gson.annotations.SerializedName

data class CompanyItem(
    @SerializedName("bs_company_statement")
    val bsCompanyStatement: String,
    @SerializedName("business_name")
    val businessName: String,
    @SerializedName("buzzword")
    val buzzword: String,
    @SerializedName("catch_phrase")
    val catchPhrase: String,
    @SerializedName("duns_number")
    val dunsNumber: String,
    @SerializedName("employee_identification_number")
    val employeeİdentificationNumber: String,
    @SerializedName("full_address")
    val fullAddress: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("industry")
    val industry: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("suffix")
    val suffix: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("uid")
    val uid: String
)