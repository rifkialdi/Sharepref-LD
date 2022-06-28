package com.example.sharepref_ld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sharepref_ld.databinding.ItemDashboardBinding

class DashboardAdapter(val listItem: ArrayList<DashboardModel>/*, val listener: IOnAdapterListener*/) :
    RecyclerView.Adapter<DashboardAdapter.ViewModel>() {

    /* Cara OnClick Dicoding */
    private lateinit var onItemClickCallBack: IOnAdapterListener
    fun setOnItemClickCallBack(onItemClickCallBack: IOnAdapterListener) {
        this.onItemClickCallBack = onItemClickCallBack
    }
    /* Cara OnClick Dicoding */

    class ViewModel(val binding: ItemDashboardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        return ViewModel(
            ItemDashboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        val item = listItem[position]
        holder.binding.idtvName.text = item.name
        holder.binding.idtvAge.text = item.age.toString()

//        cara Lazday
////        holder.itemView.setOnClickListener {
////            listener.onClick(item)
////        }

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onClick(item)
        }

    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    interface IOnAdapterListener {
        fun onClick(data: DashboardModel)
    }
}