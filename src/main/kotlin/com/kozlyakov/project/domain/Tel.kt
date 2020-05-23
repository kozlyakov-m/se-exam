package com.kozlyakov.project.domain

import javax.persistence.*


@Entity
@Table(name = "tel")
data class Tel @JvmOverloads constructor(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
        val id: Int = 0,

        @Column(name = "number")
        val name: String = "",

        @Column(name = "employee_id")
        val employeeId: Int = 0

)