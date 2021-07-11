package com.example.zomatoapp.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatoapp.R
import com.example.zomatoapp.api.CollectionX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.food_item.view.*

class FoodAdapter(private val context: Context): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private var collect:List<CollectionX> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val collect=collect[position]
        holder.restname.text=collect.title.toString()
        holder.fooddesc.text=collect.description.toString()

        Picasso.with(context)
            .load(collect.imageUrl)
            .into(holder.foodimage)

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse(collect.url.toString())
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return collect.size
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val foodimage=itemView.iv_image
        val restname=itemView.tv_tittle
        val fooddesc=itemView.tv_description

    }

    fun setStateWiseTracker(list: List<CollectionX>){
        this.collect=list
        notifyDataSetChanged()
    }
}