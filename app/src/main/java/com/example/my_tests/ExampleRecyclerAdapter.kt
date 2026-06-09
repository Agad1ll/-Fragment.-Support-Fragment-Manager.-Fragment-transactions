package com.example.my_tests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_tests.databinding.ExampleAdapterBinding

class ExampleRecyclerAdapter (): RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>(){
    private val adapterList=mutableListOf<Product>()
    inner class ExampleViewHolder(private var binding: ExampleAdapterBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Product){
            binding.tvProductTitle.text=item.title
            binding.tvProductPrice.text=item.price.toString()

        }
    }
    fun submitList(list: List<Product>){
        adapterList.clear()
        adapterList.addAll(list)

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleRecyclerAdapter.ExampleViewHolder {
        return ExampleViewHolder(
            ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(
        holder: ExampleRecyclerAdapter.ExampleViewHolder,
        position: Int
    ) {
        holder.onBind(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

}