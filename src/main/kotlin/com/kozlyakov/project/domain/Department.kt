package com.kozlyakov.project.domain

import javax.persistence.*


@Entity
@Table(name = "departments")
data class Department @JvmOverloads constructor(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
        val id: Int = 0,

        @Column(name = "department")
        val login: String = "",

        @Column(name = "tel")
        val tel: Int = 0
)