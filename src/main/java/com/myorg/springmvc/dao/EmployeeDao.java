package com.myorg.springmvc.dao;

import com.myorg.springmvc.entities.Department;
import com.myorg.springmvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/20.
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA"),null,null));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB"),null,null));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC"),null,null));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD"),null,null));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE"),null,null));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public EmployeeDao() {
    }

    public Collection<Employee> getAll() {
        return employees.values();

    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
