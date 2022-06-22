package com.rumeysaozer.coroutinesmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.coroutinesmvvm.adapter.CompanyAdapter
import com.rumeysaozer.coroutinesmvvm.databinding.ActivityMainBinding
import com.rumeysaozer.coroutinesmvvm.service.CompanyService
import com.rumeysaozer.coroutinesmvvm.service.MainRepository
import com.rumeysaozer.coroutinesmvvm.viewmodel.CompanyViewModel
import com.rumeysaozer.coroutinesmvvm.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewmodel : CompanyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val companyService = CompanyService.getInstance()
        val mainRepository = MainRepository(companyService)
        viewmodel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(CompanyViewModel::class.java)
        loadData()
        viewmodel.getData()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun loadData(){
       viewmodel.companyList.observe(this, Observer { company->
           company.let {
               val adapter = CompanyAdapter(company)
               binding.recyclerView.adapter = adapter
           }

       })
    }
}