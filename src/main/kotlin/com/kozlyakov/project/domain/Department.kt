package com.kozlyakov.project.domain

import javax.persistence.*


@Entity
@Table(name = "departments")
data class Department @JvmOverloads constructor(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
        var id: Int = 0,

        @Column(name = "department")
        var department: String = "",

        @Column(name = "tel")
        var tel: Int = 0
)