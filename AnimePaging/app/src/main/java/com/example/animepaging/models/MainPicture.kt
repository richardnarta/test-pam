package com.example.animepaging.models

import com.google.gson.annotations.SerializedName

data class MainPicture (

  @SerializedName("medium")
  var medium : String? = null,

  @SerializedName("large"  )
  var large  : String? = null

)