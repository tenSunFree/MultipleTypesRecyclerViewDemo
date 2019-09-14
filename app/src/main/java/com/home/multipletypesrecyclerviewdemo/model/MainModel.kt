package com.home.multipletypesrecyclerviewdemo.model

import java.util.*

class MainModel {

    interface OnMainDataListener {
        fun onSuccess(mainData: MainBean)
    }

    fun getMainData(listener: OnMainDataListener) {
        val mainData = MainBean(
            getMainDessertDataList(), getMainAnimalDataList(), getMainLandscapeDataList()
        )
        listener.onSuccess(mainData)
    }

    private fun getMainDessertDataList(): ArrayList<MainBean.Dessert> {
        val mainDessertDataList = ArrayList<MainBean.Dessert>()
        mainDessertDataList.add(
            MainBean.Dessert(
                "忘憂草莓千層",
                "如同它的名字一般，夾藏著滿滿的草莓內餡，搭配清爽的鮮奶油以及，酸甜滋味讓人瞬間忘卻一切的煩惱般，令人回味無窮！",
                "250",
                "https://pic.pimg.tw/breeze8717/1547565059-3998991885_l.jpg"
            )
        )
        mainDessertDataList.add(
            MainBean.Dessert(
                "小山園抹茶草莓千層",
                "採用小山園抹茶粉所製成的抹茶千層，略苦的抹茶搭配顆顆飽滿的草莓，成為冬季最美好的滋味，融合柔順的鮮奶油，讓人忍不住一口接一口。",
                "200",
                "https://icrvb3jy.xinmedia.com/solomo/article/160638/F0C04498-6434-1286-AD10-1B252C29FB49.jpeg"
            )
        )
        mainDessertDataList.add(
            MainBean.Dessert(
                "綿綿芋頭千層蛋糕",
                "使用新鮮大甲芋頭加入千層中，每一口都吃的到鬆軟綿密的芋頭內餡，香濃的滋味讓吃過的人都讚不絕口， 成為繼小山園抹茶千層之後的新人氣王！",
                "220",
                "https://pic.pimg.tw/jop6404/1554482142-1612709968_l.jpg"
            )
        )
        return mainDessertDataList
    }

    private fun getMainAnimalDataList(): ArrayList<MainBean.Animal> {
        val mainAnimalDataList = ArrayList<MainBean.Animal>()
        mainAnimalDataList.add(
            MainBean.Animal(
                "耳廓狐",
                "也稱耳郭狐、大耳小狐、大耳狐與沙漠小狐，是一種分布於北非撒哈拉的小型夜行狐，以其不同尋常的大耳朵而聞名。",
                "https://ipetgroup.com/photo/131396_0_620.jpeg"
            )
        )
        mainAnimalDataList.add(
            MainBean.Animal(
                "眼鏡猴",
                "體型小，身長約10公分；黃褐色體毛；眼睛很大而圓，甚至比腦容量還大，滿月般的大眼睛宛如戴著一幅眼鏡而得名。",
                "https://www.jgospel.net/jgospel_media/26625/.jpg"
            )
        )
        return mainAnimalDataList
    }

    private fun getMainLandscapeDataList(): ArrayList<MainBean.Landscape> {
        val mainLandscapeDataList = ArrayList<MainBean.Landscape>()
        mainLandscapeDataList.add(
            MainBean.Landscape(
                "鬱金香田",
                "濃艷的景色讓人頓時忘了世俗的憂愁，還未到荷蘭，就聞到了各種鬱金香的香味。婀娜多姿的身軀仿佛在隨風擺動，宛如荷蘭美少女在優雅的起舞。",
                "荷蘭",
                "https://i1.kknews.cc/SIG=nnl0kl/128000072444rqq4285q.jpg"
            )
        )
        mainLandscapeDataList.add(
            MainBean.Landscape(
                "愛琴海",
                "愛琴海的美，是蔚藍的，讓人靜謐而充滿遐想；愛琴海的美，是純潔的，讓欣喜而充滿嚮往。",
                "希臘",
                "https://i1.kknews.cc/SIG=pmd5g7/127r0005qop2oon3q3p8.jpg"
            )
        )
        mainLandscapeDataList.add(
            MainBean.Landscape(
                "彩虹河",
                "它被公認為是世界上最美麗的河流之一。它是如此的獨特，只要看它一眼，就可以給人留下不可磨滅的印象，但它的顏色並不總是如此美麗，彩虹色的河流只出現在每年特定的季節。",
                "哥倫比亞",
                "https://i1.kknews.cc/SIG=2ku66h8/127r0005qop583pnsors.jpg"
            )
        )
        return mainLandscapeDataList
    }
}