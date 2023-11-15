package com.example.animepaging.models

import com.google.gson.annotations.SerializedName

data class Data (
  @SerializedName("node")
  var node : Node? = Node()

)