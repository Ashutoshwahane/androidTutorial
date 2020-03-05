package com.cybernerd.cypherx.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cybernerd.cypherx.R
import com.cybernerd.cypherx.model.DepartmentResponse

class RecycleAdapter(val context : Context) : RecyclerView.Adapter<RecycleAdapter.MyViewHolder>() {

    var alldepartmentresponse : List<DepartmentResponse> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_adapter_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return alldepartmentresponse.size
    }

    override fun onBindViewHolder(holder: RecycleAdapter.MyViewHolder, position: Int) {
        holder.id.text = alldepartmentresponse.get(position).id
        holder.name.text = alldepartmentresponse.get(position).name
        holder.description.text = alldepartmentresponse.get(position).description
    }

    fun setdepartment(alldepartmentresponse: List<DepartmentResponse>){
        this.alldepartmentresponse = alldepartmentresponse
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!){
        val id : TextView = itemView!!.findViewById(R.id.id)
        val name : TextView = itemView!!.findViewById(R.id.name)
        val description : TextView = itemView!!.findViewById(R.id.description)
    }
}