package com.retrofit.kotlin.model

import com.google.gson.annotations.SerializedName

data class BeanList(

        @SerializedName("result")
        val list: ArrayList<Bean>?
)