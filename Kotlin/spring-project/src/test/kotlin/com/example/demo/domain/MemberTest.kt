package com.example.demo.domain

import com.example.demo.config.JpaAuditingConfig
import org.assertj.core.api.Assertions.assertThat
import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters
import org.jeasy.random.FieldPredicates
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import kotlin.streams.toList

@DataJpaTest
@Import(value = [JpaAuditingConfig::class])
internal class MemberTest {

    @Autowired
    private lateinit var memberRepository: MemberRepository

    private val easyRandomParameters = EasyRandomParameters().excludeField(FieldPredicates.named("id"))
    private val easyRandom = EasyRandom(easyRandomParameters)

    private val memberFixture = Member(
            name = "asd",
            age = 1
    )

    @Test
    fun findByIdIn() {
        val memberFixtures = easyRandom.objects(Member::class.java, 4).toList()
        val savedMembers = memberRepository.saveAll(memberFixtures)
        val idList = savedMembers.subList(0, 2).map { it.getId()!! }

        val actual = memberRepository.findByIdIn(idList)

        assertThat(actual).hasSize(2)
    }

    @Test
    fun test() {
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

        assertThat(memberFixture.name).isEqualTo("bbbb")
    }

    @Test
    fun also() {
        memberFixture.also {
            println(it.age)
            it.age = 12
        }

        assertThat(memberFixture.age).isEqualTo(12)
    }
}

