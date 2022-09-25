package com.android.docpreter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class recyclerAdapter(private val aList:ArrayList<prescModal>):
    RecyclerView.Adapter<recyclerAdapter.MyViewHolder>() {
   class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val prescName:TextView =itemView.findViewById(R.id.presName)
            val prescBy:TextView = itemView.findViewById(R.id.precBy)
            val interval:TextView = itemView.findViewById(R.id.intervals)
//            val notButton:ImageView = itemView.findViewById(R.id.notifyImv)
//            val saveOff:ImageView = itemView.findViewById(R.id.intervals)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.in_effect_design,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curItem = aList.get(position)
        holder.prescName.text = curItem.prescName
        holder.prescBy.text = curItem.prescBy
        holder.interval.text = curItem.interval
    }

    override fun getItemCount(): Int {
       return aList.size
    }
}