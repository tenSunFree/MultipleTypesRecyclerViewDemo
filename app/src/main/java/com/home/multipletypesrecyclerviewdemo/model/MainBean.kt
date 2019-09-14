package com.home.multipletypesrecyclerviewdemo.model

import com.google.gson.annotations.SerializedName

data class MainBean(
    @SerializedName("dessert")
    val dessert: List<Dessert>,
    @SerializedName("animal")
    val animal: List<Animal>,
    @SerializedName("landscape")
    val landscape: List<Landscape>
) {
    data class Landscape(
        @SerializedName("name")
        val name: String,
        @SerializedName("introduction")
        val introduction: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("imageUrl")
        val imageUrl: String
    )

    data class Animal(
        @SerializedName("name")
        val name: String,
        @SerializedName("introduction")
        val introduction: String,
        @SerializedName("imageUrl")
        val imageUrl: String
    )

    data class Dessert(
        @SerializedName("name")
        val name: String,
        @SerializedName("introduction")
        val introduction: String,
        @SerializedName("money")
        val money: String,
        @SerializedName("imageUrl")
        val imageUrl: String
    )
}