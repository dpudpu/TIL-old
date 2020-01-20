package com.example.demo.service

import com.example.demo.controller.MemberCreateDto
import com.example.demo.controller.MemberResponseDto
import com.example.demo.domain.Member
import com.example.demo.domain.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
        private val memberRepository: MemberRepository
) {
    fun save(memberCreateDto: MemberCreateDto): MemberResponseDto {
        val member = memberRepository.save(
                Member(
                        name = memberCreateDto.name,
                        age = memberCreateDto.age))

        return MemberResponseDto(
                name = member.name,
                age = member.age,
                id = member.getId()!!
        )
    }
}