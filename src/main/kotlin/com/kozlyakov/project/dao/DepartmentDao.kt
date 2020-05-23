package com.kozlyakov.project.dao

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.persist.Transactional
import com.kozlyakov.project.domain.Department
import com.kozlyakov.project.domain.Employee
import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class DepartmentDao @Inject constructor(
        var entityManager: Provider<EntityManager>
) {
    fun findById(id: Int): Department?{
        return entityManager.get().find(Department::class.java, id)
    }

    fun getAll(): List<Department> {
        val criteriaQuery = entityManager.get().criteriaBuilder.createQuery(Department::class.java)
        val rootEntry: Root<Department> = criteriaQuery.from(Department::class.java)
        val all: CriteriaQuery<Department> = criteriaQuery.select(rootEntry)
        val allQuery: TypedQuery<Department> = entityManager.get().createQuery(all)
        return allQuery.resultList
    }

    @Transactional
    fun save(gsonDepartment: Department) {
        val em = entityManager.get()
        em.transaction.begin()

        val department = Department()
        department.department = gsonDepartment.department
        department.tel = gsonDepartment.tel

        em.persist(department)
        em.transaction.commit()

    }

    @Transactional
    fun delete(id: Int): Boolean {
        val em = entityManager.get()
        val e = this.findById(id) ?: return false
        em.transaction.begin()
        em.remove(e)
        em.transaction.commit()
        return true
    }
}