package com.zaurtregulov.spring.mvc.dao;

import com.zaurtregulov.spring.mvc.entity.Employee;
import com.zaurtregulov.spring.mvc.dao.EmployeeDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private SessionFactory factory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = null;
        try (Session session = factory.openSession()) {
            allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        }
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = factory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = factory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = factory.getCurrentSession();
        session.createMutationQuery("delete from Employee where id = :employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();
    }
}
