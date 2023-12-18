package com.sleepy.sleeplab.ui.home.tips

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sleepy.sleeplab.data.model.duration.DurationNewsDataClass
import com.sleepy.sleeplab.data.model.tips.TipsNewsDataClass
import com.sleepy.sleeplab.databinding.RvSleepBinding
import com.sleepy.sleeplab.ui.home.duration.DurationWebViewActivity
import com.sleepy.sleeplab.ui.home.duration.SleepDurationAdapter

class TipsForSleepAdapter(private val newsList: List<TipsNewsDataClass>) :
    RecyclerView.Adapter<TipsForSleepAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: RvSleepBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(news: TipsNewsDataClass) {
            binding.apply {
                Glide.with(itemView)
                    .load(news.photo)
                    .centerCrop()
                    .into(imgNews)

                tvTitleNews.text = news.title
                tvDescNews.text = news.desc

                binding.rvSleep.setOnClickListener {
                    val intent = Intent(itemView.context, DurationWebViewActivity::class.java)
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
