package com.proxy.lazy.lazyproxy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("레이지 로딩일시 프록시 객체")
    void test01() {
        final Member member = memberRepository.findById(1L).get();
        final Class<? extends Team> teamClass = member.getTeam().getClass();

        System.out.println(teamClass);
        assertThat(teamClass).isNotEqualTo(Team.class);
    }

    @Test
    @DisplayName("Fetch join 프록시 x -> Team 객체 o")
    void test02() {
        final Member member = memberRepository.findByIdWithFetch(1L);
        final Class<? extends Team> teamClass = member.getTeam().getClass();

        assertThat(teamClass).isEqualTo(Team.class);
    }

    /**
     * 쿼리 메소드로 이미 조회된 Member를 Fetch join으로 다시 조회하면 한 번 더 쿼리를 사용하지만 같은 인스턴스다.
     * 참조하는 Team은 이미 앞에서 호출했기 때문에 Proxy 객체로 가지고 있다. (원래는 Team 객체로 갖고 있음)
     */
    @Test
    @DisplayName("Fetch 조인으로 한 번 더 조회, 같은 인스턴스 but 쿼리 한 번 더 실행")
    void test03() {
        final Member member = memberRepository.findById(1L).get();
        final Member member2 = memberRepository.findByIdWithFetch(1L);

        assertThat(member == member2).isTrue();
        assertThat(member.getTeam() == member2.getTeam());
    }

}