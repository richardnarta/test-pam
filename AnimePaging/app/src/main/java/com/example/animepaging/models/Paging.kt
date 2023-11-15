package com.example.animepaging.models

import com.google.gson.annotations.SerializedName


data class Paging (

  @SerializedName("next")
  var next : String? = null,

  @SerializedName("prev")
  var prev : String? = null

)