package com.example.animepaging.models

import com.google.gson.annotations.SerializedName

data class Season (

  @SerializedName("year")
  var year : Int? = null,

  @SerializedName("season")
  var season : String? = null

)