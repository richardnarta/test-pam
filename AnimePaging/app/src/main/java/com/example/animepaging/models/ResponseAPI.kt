package com.example.animepaging.models

import com.google.gson.annotations.SerializedName

data class ResponseAPI (
  @SerializedName("data")
  var data : ArrayList<Data> = arrayListOf(),

  @SerializedName("paging")
  var paging : Paging? = Paging(),

  @SerializedName("season")
  var season : Season? = Season()
)