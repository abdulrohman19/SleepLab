package com.sleepy.sleeplab.ui.home.disorder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.data.model.disorder.DisorderNewsDataClass
import com.sleepy.sleeplab.databinding.RvSleepBinding

class SleepDisorderAdapter(private val newsList: List<DisorderNewsDataClass>) :
    RecyclerView.Adapter<SleepDisorderAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: RvSleepBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(news: DisorderNewsDataClass) {
            binding.apply {
                Glide.with(itemView)
                    .load(news.photo)
                    .centerCrop()
                    .into(imgNews)

                    tvTitleNews.text = news.title
                    tvDescNews.text = news.desc

                    binding.rvSleep.setOnClickListener {
                        val intent = Intent(itemView.context,DisorderWebViewActivity::class.java)
                        intent.putExtra("url",news.link)
                        itemView.context.startActivity(intent)

                    }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = RvSleepBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder((view))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
