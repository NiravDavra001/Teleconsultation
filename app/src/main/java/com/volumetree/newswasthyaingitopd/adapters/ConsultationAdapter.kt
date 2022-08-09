package com.volumetree.newswasthyaingitopd.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volumetree.newswasthyaingitopd.databinding.ConsultationRowBinding

class ConsultationAdapter(
    private val docList: List<String>,
   val reconsult: () -> Unit
) :
    RecyclerView.Adapter<ConsultationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ConsultationRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(docList[position])
    }

    override fun getItemCount() = docList.size

    inner class ViewHolder(private val binding: ConsultationRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hospitalName: String) {
            if (adapterPosition == 0 || adapterPosition == 3) {
                binding.tvReconsult.isSelected = true
            }
            binding.tvReconsult.setOnClickListener {
                reconsult.invoke()
            }
        }
    }
}