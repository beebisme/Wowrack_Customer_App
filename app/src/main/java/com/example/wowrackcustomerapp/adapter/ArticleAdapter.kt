package com.example.wowrackcustomerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wowrackcustomerapp.data.models.Articles
import com.example.wowrackcustomerapp.data.response.DataItem
import com.example.wowrackcustomerapp.databinding.ItemArticleBinding


class ArticleAdapter(private val listArticle: List<DataItem>,private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<ArticleAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: ItemArticleBinding = ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val article = listArticle[position]
        holder.bind(article)

        holder.itemView.setOnClickListener {
            onItemClick(article.id) // Pass the article ID to the onItemClick function
        }
    }

    class ListViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {



        fun bind(article: DataItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(article.imageUrl)
                    .into(ivCloudRaya)
                tvCloudRaya.text = article.title
                tvDesc.text = article.description

                // Anda dapat menambahkan listener klik di sini
                root.setOnClickListener {
                    // Handle klik di sini
                }
            }
        }
    }
}
