package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //define field for entity manager

    private final EntityManager entityManager;

    //set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query

        //Case sensitive
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list

        List<Employee> employees = theQuery.getResultList();
        //return the results

        return employees;
    }

    @Override
    public Employee findById(int id) {

        var result = entityManager.find(Employee.class, id);

        return result;
    }

    @Override
    public Employee save(Employee employee) {

        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {

        var employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

    }


}
