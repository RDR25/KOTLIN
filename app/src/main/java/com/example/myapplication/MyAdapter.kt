package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter():RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    var userList = emptyList<user>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = userList[position]

        var id = holder.itemView.findViewById<TextView>(R.id.r_row_id)
        id.text = currentItem.id.toString()

        var firstName = holder.itemView.findViewById<TextView>(R.id.r_firstName)
        firstName.text = currentItem.firstName

        var lastName = holder.itemView.findViewById<TextView>(R.id.r_lastName)
        lastName.text=currentItem.lastName

        var age = holder.itemView.findViewById<TextView>(R.id.room_row_age)
        age.text=currentItem.age.toString()
    }

    override fun getItemCount(): Int {

        return userList.size
    }

    fun setData (user: List<user>){
        userList=user
        notifyDataSetChanged()
    }
}