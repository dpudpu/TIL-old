package com.example.demo.controller

import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
internal class MemberControllerTest(
        @Autowired
        private val webClient: WebTestClient
) {
    private val uri = linkTo(MemberController::class.java).toUri().toString()

    @Test
    internal fun 회원가입() {
        val memberCreateDto =  MemberCreateDto(
                name = "DD",
                age = 20
        )

       val response = webClient.post().uri(uri)
                .contentType(APPLICATION_JSON)
                .body(Mono.just(memberCreateDto), MemberCreateDto::class.java)
                .exchange()
                .expectStatus().isCreated
                .expectBody(MemberResponseDto::class.java).returnResult().responseBody

        assertThat(response!!.name).isEqualTo(memberCreateDto.name)
        assertThat(response.age).isEqualTo(memberCreateDto.age)
    }
}