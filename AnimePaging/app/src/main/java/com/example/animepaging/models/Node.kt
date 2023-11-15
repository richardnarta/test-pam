package com.example.animepaging.models

import com.google.gson.annotations.SerializedName

data class Node (
  @SerializedName("id")
  var id : Int? = null,

  @SerializedName("title")
  var title : String? = null,

  @SerializedName("main_picture")
  var mainPicture : MainPicture? = MainPicture()

)