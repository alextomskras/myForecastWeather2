package com.resocoder.myweather2.data.db.entity


data class Request(
        val language: String, // en
        val query: String, // Los Angeles, United States of America
        val type: String, // City
        val unit: String // m
)