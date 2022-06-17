package id.asad.news.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.asad.news.R
import id.asad.news.data.remote.network.ArticlesItem
import id.asad.news.databinding.ItemRowNewsBinding
import id.asad.news.ui.webview.WebViewActivity

class NewsAdapter : PagedListAdapter<ArticlesItem, NewsAdapter.NewsViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticlesItem>(){
            override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem.title == newItem.title
            }
            override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
               return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemRowNewsBinding = ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemRowNewsBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articlesItem = getItem(position)
        if (articlesItem != null){
            holder.bind(articlesItem)
        }
    }

    inner class NewsViewHolder(private val binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(articlesItem: ArticlesItem){
            with(binding){
                tvRowSource.text = articlesItem.source?.name
                tvRowTitle.text = articlesItem.title
                tvRowDescription.text = articlesItem.description
                Glide.with(binding.root)
                    .load(articlesItem.urlToImage)
                    .placeholder(R.drawable.image_available)
                    .error(R.drawable.no_image_2)
                    .into(binding.imgRowNews)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, WebViewActivity::class.java)
                    intent.putExtra(WebViewActivity.KEY_URL_NEWS, articlesItem.url)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}