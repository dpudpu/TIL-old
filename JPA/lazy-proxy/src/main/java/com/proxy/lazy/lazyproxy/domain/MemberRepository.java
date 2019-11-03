package com.proxy.lazy.lazyproxy.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT m FROM Member m LEFT JOIN FETCH m.team WHERE m.id = :id")
    Member findByIdWithFetch(@Param(value = "id") long id);
}
