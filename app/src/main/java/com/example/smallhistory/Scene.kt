package com.example.smallhistory

data class  Scenes (
    val scenes: ArrayList<Scene>
    )

data class Scene (
    val text: String,
    val buttons: List<But>
)
data class But (
    val text: String,
    val next: Int
    )