package com.kozlyakov.project.dao

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.persist.Transactional
import com.kozlyakov.project.domain.Employee
import javax.persistence.EntityManager
import javax.persistence.NoResultException
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class EmployeeDao @Inject constructor(
        var entityManager: Provider<EntityManager>
) {
    fun findById(id: Int): Employee? {
        return entityManager.get().find(Employee::class.java, id)
    }

    fun findByTel(tel: Int): Employee? {
        val em = entityManager.get()
        val q: TypedQuery<Employee> = em.createQuery("SELECT a FROM Employee a JOIN a.tel p WHERE p = :number", Employee::class.java)
        q.setParameter("number", tel)
        return try {
            q.singleResult
        } catch (e: NoResultException) {
            null
        }
    }

    fun getAll(): List<Employee> {
        val criteriaQuery = entityManager.get().criteriaBuilder.createQuery(Employee::class.java)
        val rootEntry: Root<Employee> = criteriaQuery.from(Employee::class.java)
        val all: CriteriaQuery<Employee> = criteriaQuery.select(rootEntry)
        val allQuery: TypedQuery<Employee> = entityManager.get().createQuery(all)
        return allQuery.resultList
    }

    fun findByDepartmentId(id: Int): List<Employee> {

        val query = entityManager.get().createQuery(
                "FROM Employee WHERE department_id = $id",
                Employee::class.java
        )

        return query.resultList
    }

    @Transactional
    fun save(gsonEmployee: Employee) {
        val em = entityManager.get()
        em.transaction.begin()

        val e = Employee()
        e.name = gsonEmployee.name
        e.departmentId = gsonEmployee.departmentId
        e.tel = gsonEmployee.tel

        em.persist(e)
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