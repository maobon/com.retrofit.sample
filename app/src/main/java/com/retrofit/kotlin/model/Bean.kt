package com.retrofit.kotlin.model

import com.google.gson.annotations.SerializedName


data class Bean(

        @SerializedName("_id")
        private var id: String?,

        @SerializedName("title")
        private val title: String?,

        @SerializedName("pic")
        private val pic: String?,

        @SerializedName("year")
        private val year: Int?,

        @SerializedName("month")
        private val month: Int?,

        @SerializedName("day")
        private val day: Int?,

        @SerializedName("des")
        private val des: String?,

        @SerializedName("lunar")
        private val lunar: String?
)