package io.github.kartiksethi.dao;

import io.github.kartiksethi.model.EmployeeDo;

public interface EmployeeDao {
    void create(String client, EmployeeDo obj) throws Exception;

    void delete(String client, String employeeId) throws Exception;

    EmployeeDo get(String client, String employeeId) throws Exception;
}
