package com.rumeysaozer.coroutinesmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.coroutinesmvvm.databinding.ItemRowBinding
import com.rumeysaozer.coroutinesmvvm.model.CompanyItem

class CompanyAdapter(val companyList : ArrayList<CompanyItem>):RecyclerView.Adapter<CompanyAdapter.CompanyHolder>() {
    class CompanyHolder(val binding : ItemRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyHolder {
      val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CompanyHolder(binding)
    }

    override fun onBindViewHolder(holder: CompanyHolder, position: Int) {
        holder.binding.textView.text = companyList[position].businessName
    }

    override fun getItemCount(): Int {
       return companyList.size
    }
}