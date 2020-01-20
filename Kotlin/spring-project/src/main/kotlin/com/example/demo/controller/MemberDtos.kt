package com.example.demo.controller

data class MemberCreateDto(
        val name: String,
        val age: Int
)

data class MemberResponseDto(
        val name: String,
        val age: Int,
        val id: Long
)
