package com.huudung.fileexplorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val items : ArrayList<FileModel>) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.icon.setImageResource(items[position].icon)
        holder.itemView.setOnClickListener {
            val nextFolderFragment = NextFolderFragment()
            val bundle = Bundle()
            bundle.putString("address",items[position].address)
            nextFolderFragment.arguments = bundle
            (holder.itemView.context as AppCompatActivity)
                .supportFragmentManager
                .beginTransaction()
                .add(R.id.ListFile, nextFolderFragment)
                .addToBackStack("Folder")
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon : ImageView
        val name : TextView
        init {
            icon = itemView.findViewById(R.id.icon)
            name = itemView.findViewById(R.id.name)
        }
    }
}