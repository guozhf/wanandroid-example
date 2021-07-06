package com.zephyr.wanandroid_z.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zephyr.baselib.data.ArticleEntity
import com.zephyr.baselib.data.TabEntity
import com.zephyr.wanandroid_z.databinding.ItemHomeArticleBinding
import com.zephyr.wanandroid_z.databinding.ItemTabBinding

/**
 * created by zephyr on 2020/12/7 09 : 59
 *
 */
class TabAdapter(private val list: List<TabEntity>) :
    RecyclerView.Adapter<TabAdapter.TabViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
        return TabViewHolder(
            ItemTabBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        val plant = list[position]
        (holder as TabViewHolder).bind(plant)
    }

    override fun getItemCount(): Int = list.size

    class TabViewHolder(
        private val binding: ItemTabBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TabEntity) {
            binding.tvName.text = item.name
        }
    }
}