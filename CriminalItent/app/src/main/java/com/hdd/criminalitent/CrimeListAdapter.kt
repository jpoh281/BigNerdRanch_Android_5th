package com.hdd.criminalitent

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hdd.criminalitent.databinding.ListItemCrimeBinding
import com.hdd.criminalitent.databinding.ListItemSeriousCrimeBinding

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${crime.title} clicked", Toast.LENGTH_SHORT)
                .show()
        }
    }
}

class SeriousCrimeHolder(
    private val binding: ListItemSeriousCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()
        binding.crimeWarning.text = "contact police"
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${crime.title} clicked", Toast.LENGTH_SHORT)
                .show()
        }
    }

}

class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if(viewType == 0) {
            val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
            CrimeHolder(binding)
        } else {
            val binding = ListItemSeriousCrimeBinding.inflate(inflater, parent, false)
            SeriousCrimeHolder(binding)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(crimes[position].requirePolice){
            1
        }else {
            0
        }
    }

    override fun getItemCount() = crimes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]
        if(holder is SeriousCrimeHolder){
            return holder.bind(crime)
        } else {
            (holder as CrimeHolder).bind(crime)
        }
    }

}