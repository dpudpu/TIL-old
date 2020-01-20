package com.example.demo.domain

import javax.persistence.*

@Entity
class Member(
        @Column(unique = true)
        var name: String,

        @Column
        var age: Int,

        @ManyToMany
        @JoinTable(
                name = "asd",
                inverseJoinColumns = [JoinColumn(name = "aaa_id")]
        )
        var a: List<Team> = arrayListOf()
) : AbstractJpaPersistable()