package com.kozlyakov.project.domain

import javax.persistence.*


@Entity
@Table(name = "employees")
data class Employee @JvmOverloads constructor(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
        val id: Int = 0,

        @Column(name = "name")
        var name: String = "",

        @Column(name = "department_id")
        var departmentId: Int = 0,

        @ElementCollection
        @CollectionTable(name = "tel", joinColumns = [JoinColumn(name = "employee_id")])
        @Column(name = "number")
        var tel: List<Int> = listOf()
)