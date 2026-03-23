package io.github.kartiksethi;

import io.github.kartiksethi.dao.EmployeeDao;
import io.github.kartiksethi.model.EmployeeDo;
import io.github.kartiksethi.proxy.EmployeeDaoProxy;


public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDao employeesDao = new EmployeeDaoProxy();
            employeesDao.create("ADMIN", new EmployeeDo());
            System.out.println("Create Operation Successful");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}