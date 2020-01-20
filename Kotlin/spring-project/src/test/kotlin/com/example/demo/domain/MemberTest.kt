package com.example.demo.domain

import com.example.demo.config.JpaAuditingConfig
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DataJpaTest
@Import(value = [JpaAuditingConfig::class])
internal class MemberTest {

    @Autowired
    private lateinit var memberRepository: MemberRepository

    private val memberFixture = Member(
            name = "asd",
            age = 1
    )

    @Test
    fun name() {
        val savedMember = memberRepository.save(memberFixture)
        val member = memberRepository.findByName(memberFixture.name)

        println("${member.age} - ${member.name} ")
        assertThat(savedMember).isEqualTo(member)
        assertThat(memberFixture.name).isEqualTo(member.name)
        assertThat(memberFixture.age).isEqualTo(member.age)
    }

    @Test
    fun apply() {
        memberFixture.apply {
            println(name)
            println(age)
            name = "bbbb"
        }

        assertThat(memberFixture.name).isEqualTo("bbb")
    }

    @Test
    fun also() {
        memberFixture.also {
            println(it.age)
            it.age = 12;
        }

        assertThat(memberFixture.age).isEqualTo(12)
    }
}

