package com.melik.repo;

import com.melik.domain.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author mselvi
 * @Created 19.02.2024
 */

@ApplicationScoped
@Transactional
public class EmployeeRepository {

    @Inject
    private EntityManager entityManager;

    public List<Employee> findAll() {
        String hqlQuery="Select employee From Employee employee";
        TypedQuery<Employee> query = entityManager.createQuery(hqlQuery, Employee.class);
        return query.getResultList();

    }

    public Optional<Employee> findById(Long id) {
        String hqlQuery="Select employee From Employee employee where employee.id =:id";
        TypedQuery<Employee> query = entityManager.createQuery(hqlQuery, Employee.class);
        query.setParameter("id",id);
        return Optional.ofNullable(query.getSingleResult());
    }

    public void persist(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee save(Employee employeeById) {
        return entityManager.merge(employeeById);
    }
}
