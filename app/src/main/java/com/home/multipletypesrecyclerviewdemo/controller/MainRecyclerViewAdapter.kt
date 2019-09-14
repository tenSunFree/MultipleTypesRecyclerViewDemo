package com.home.multipletypesrecyclerviewdemo.controller

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.home.multipletypesrecyclerviewdemo.R
import com.home.multipletypesrecyclerviewdemo.model.MainBean
import kotlinx.android.synthetic.main.activity_main_recycler_view_animal_item.view.*
import kotlinx.android.synthetic.main.activity_main_recycler_view_dessert_item.view.*
import kotlinx.android.synthetic.main.activity_main_recycler_view_landscape_item.view.*

class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var mainBean: MainBean

    enum class CellType {
        DESSERT,
        DESSERT_HEADER,
        DESSERT_FOOTER,
        ANIMAL,
        ANIMAL_HEADER,
        ANIMAL_FOOTER,
        LANDSCAPE,
        LANDSCAPE_HEADER,
        LANDSCAPE_FOOTER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CellType.DESSERT.ordinal -> CenterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_dessert_item,
                    parent,
                    false
                )
            )
            CellType.DESSERT_HEADER.ordinal -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_dessert_header_item, parent, false
                )
            )
            CellType.DESSERT_FOOTER.ordinal -> FooterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_dessert_footer_item,
                    parent,
                    false
                )
            )
            CellType.ANIMAL.ordinal -> CenterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_animal_item,
                    parent,
                    false
                )
            )
            CellType.ANIMAL_HEADER.ordinal -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_animal_header_item, parent, false
                )
            )
            CellType.ANIMAL_FOOTER.ordinal -> FooterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_animal_footer_item,
                    parent,
                    false
                )
            )
            CellType.LANDSCAPE.ordinal -> CenterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_landscape_item,
                    parent,
                    false
                )
            )
            CellType.LANDSCAPE_HEADER.ordinal -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_landscape_header_item, parent, false
                )
            )
            CellType.LANDSCAPE_FOOTER.ordinal -> FooterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_landscape_footer_item,
                    parent,
                    false
                )
            )
            else -> CenterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_recycler_view_dessert_item,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            CellType.DESSERT.ordinal -> {
                val headerViewHolder = holder as CenterViewHolder
                headerViewHolder.bindDessertView(mainBean.dessert[position - 1])
            }
            CellType.DESSERT_HEADER.ordinal -> {
                val headerViewHolder = holder as HeaderViewHolder
                headerViewHolder.bindDessertView()
            }
            CellType.DESSERT_FOOTER.ordinal -> {
                val footerViewHolder = holder as FooterViewHolder
                footerViewHolder.bindDessertView()
            }
            CellType.ANIMAL.ordinal -> {
                val headerViewHolder = holder as CenterViewHolder
                headerViewHolder.bindAnimalView(mainBean.animal[position - mainBean.dessert.size - 3])
            }
            CellType.ANIMAL_HEADER.ordinal -> {
                val headerViewHolder = holder as HeaderViewHolder
                headerViewHolder.bindAnimalView()
            }
            CellType.ANIMAL_FOOTER.ordinal -> {
                val footerViewHolder = holder as FooterViewHolder
                footerViewHolder.bindAnimalView()
            }
            CellType.LANDSCAPE.ordinal -> {
                val headerViewHolder = holder as CenterViewHolder
                headerViewHolder.bindLandscapeView(mainBean.landscape[position - mainBean.dessert.size - mainBean.animal.size - 5])
            }
            CellType.LANDSCAPE_HEADER.ordinal -> {
                val headerViewHolder = holder as HeaderViewHolder
                headerViewHolder.bindLandscapeView()
            }
            CellType.LANDSCAPE_FOOTER.ordinal -> {
                val footerViewHolder = holder as FooterViewHolder
                footerViewHolder.bindLandscapeView()
            }
        }
    }

    override fun getItemCount(): Int =
        mainBean.dessert.size + mainBean.animal.size + mainBean.landscape.size + 6

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> CellType.DESSERT_HEADER.ordinal
            in 1..mainBean.dessert.size -> CellType.DESSERT.ordinal
            mainBean.dessert.size + 1 -> CellType.DESSERT_FOOTER.ordinal
            mainBean.dessert.size + 2 -> CellType.ANIMAL_HEADER.ordinal
            in mainBean.dessert.size + 3..mainBean.dessert.size + mainBean.animal.size + 2 ->
                CellType.ANIMAL.ordinal
            mainBean.dessert.size + mainBean.animal.size + 3 -> CellType.ANIMAL_FOOTER.ordinal
            mainBean.dessert.size + mainBean.animal.size + 4 -> CellType.LANDSCAPE_HEADER.ordinal
            in mainBean.dessert.size + mainBean.animal.size + 5..
                    mainBean.dessert.size + mainBean.animal.size + mainBean.landscape.size + 4 ->
                CellType.LANDSCAPE.ordinal
            else -> CellType.LANDSCAPE_FOOTER.ordinal
        }
    }

    fun setMainData(mainBean: MainBean) {
        this.mainBean = mainBean
        notifyDataSetChanged()
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindDessertView() {}
        fun bindAnimalView() {}
        fun bindLandscapeView() {}
    }

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindDessertView() {}
        fun bindAnimalView() {}
        fun bindLandscapeView() {}
    }

    @SuppressLint("SetTextI18n")
    class CenterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindDessertView(dessertData: MainBean.Dessert) {
            itemView.text_view_dessert_name.text = dessertData.name
            itemView.text_view_dessert_introduction.text =
                itemView.context.getString(R.string.activity_main_recycler_view_dessert_item_introduction) + dessertData.introduction
            itemView.text_view_dessert_money.text =
                itemView.context.getString(R.string.activity_main_recycler_view_dessert_item_money) + dessertData.money
            Glide.with(itemView.context).load(dessertData.imageUrl)
                .into(itemView.image_view_dessert)
        }

        fun bindAnimalView(animalData: MainBean.Animal) {
            itemView.text_view_animal_name.text = animalData.name
            itemView.text_view_animal_introduction.text =
                itemView.context.getString(R.string.activity_main_recycler_view_dessert_item_introduction) + animalData.introduction
            Glide.with(itemView.context).load(animalData.imageUrl).into(itemView.image_view_animal)
        }

        fun bindLandscapeView(landscapeData: MainBean.Landscape) {
            itemView.text_view_landscape_name.text = landscapeData.name
            itemView.text_view_landscape_introduction.text =
                itemView.context.getString(R.string.activity_main_recycler_view_dessert_item_introduction) + landscapeData.introduction
            itemView.text_view_landscape_country.text =
                itemView.context.getString(R.string.activity_main_recycler_view_landscape_item_country) + landscapeData.country
            Glide.with(itemView.context).load(landscapeData.imageUrl)
                .into(itemView.image_view_landscape)
        }
    }
}