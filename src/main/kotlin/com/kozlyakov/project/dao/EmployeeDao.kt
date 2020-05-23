package com.kozlyakov.project.dao

import com.google.inject.Inject
import com.google.inject.Provider
import com.kozlyakov.project.domain.Employee
import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class EmployeeDao @Inject constructor(
        var entityManager: Provider<EntityManager>
) {
    fun findById(id: Int): Employee?{
        return entityManager.get().find(Employee::class.java, id)
    }
    fun getAll(): List<Employee> {
        val criteriaQuery = entityManager.get().criteriaBuilder.createQuery(Employee::class.java)
        val rootEntry: Root<Employee> = criteriaQuery.from(Employee::class.java)
        val all: CriteriaQuery<Employee> = criteriaQuery.select(rootEntry)
        val allQuery: TypedQuery<Employee> = entityManager.get().createQuery(all)
        return allQuery.resultList
    }
}