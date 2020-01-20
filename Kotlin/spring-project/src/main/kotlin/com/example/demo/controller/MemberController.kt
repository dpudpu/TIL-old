package com.example.demo.controller

import com.example.demo.service.MemberService
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
        private val memberService: MemberService
) {

    @PostMapping
    fun create(@RequestBody memberCreateDto: MemberCreateDto): ResponseEntity<MemberResponseDto> {

        val memberResponseDto = memberService.save(memberCreateDto)
        val uri = linkTo(MemberController::class.java).slash(memberResponseDto.id).toUri()
        return ResponseEntity.created(uri).body(memberResponseDto)
    }
}