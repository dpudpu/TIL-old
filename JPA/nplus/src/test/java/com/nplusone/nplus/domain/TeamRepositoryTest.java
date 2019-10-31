package com.nplusone.nplus.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("N+1 findById")
    void test1() {
        final Team team = teamRepository.findById(1L).get();
        System.out.println("-------------------------------------");
        team.getMembers().forEach(member -> System.out.println(member.getName()));
        System.out.println("-------------------------------------");
    }

    /**
     * JPQL을 실행하면 JPA는 이것을 분석해서 SQL을 생성합니다.
     * JPQL 입장에서는 즉시 로딩, 지연 로딩과 같은 글로벌 패치 전략을 무시하고 JPQL만 사용해서 SQL을 생성합니다.
     */
    @Test
    @DisplayName("N+1 findAll")
    void test2() {
        final List<Team> teams = teamRepository.findAll();

        for (final Team team : teams) {
            System.out.println("----------------------------------");
            for (final Member member : team.getMembers()) {
                System.out.println(team.getName() + " / " + member.getName());
            }
        }
    }

    @Test
    @DisplayName("N+1 JPQL로 해결 but 카테시안 곱")
    void test3() {
        final List<Team> teams = teamRepository.findAllWithJoin();

        for (final Team team : teams) {
            System.out.println("----------------------------------");
            for (final Member member : team.getMembers()) {
                System.out.println(team.getName() + " / " + member.getName());
            }
        }
    }

    @Test
    @DisplayName("N+1 JPQL로 해결 and 카테시안 곱 해결")
    void test4() {
        final List<Team> teams = teamRepository.findAllWithJoinAndDistinct();

        for (final Team team : teams) {
            System.out.println("----------------------------------");
            for (final Member member : team.getMembers()) {
                System.out.println(team.getName() + " / " + member.getName());
            }
        }
    }
}