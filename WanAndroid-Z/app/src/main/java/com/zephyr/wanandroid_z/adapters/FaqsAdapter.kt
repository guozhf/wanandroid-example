package com.zephyr.wanandroid_z.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zephyr.baselib.data.ArticleEntity
import com.zephyr.baselib.data.TabEntity
import com.zephyr.wanandroid_z.databinding.ItemFaqsBinding
import com.zephyr.wanandroid_z.databinding.ItemTabBinding

/**
 * created by zephyr on 12/16/20 17 : 08
 *
 */
class FaqsAdapter(private val list: List<ArticleEntity>) :
    RecyclerView.Adapter<FaqsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFaqsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = list[position]
        (holder as ViewHolder).bind(plant)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(
        private val binding: ItemFaqsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ArticleEntity) {
            binding.tvAuthor.text = item.author
            binding.tvTag.text = item.tags?.get(0)?.name
            binding.tvDate.text = item.niceDate
            binding.tvTitle.text = item.title
            binding.tvDesc.text = Html.fromHtml(item.desc)
        }
    }
}