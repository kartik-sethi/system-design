package io.github.kartiksethi.proxy;

import io.github.kartiksethi.dao.EmployeeDaoImpl;
import io.github.kartiksethi.dao.EmployeeDao;
import io.github.kartiksethi.model.EmployeeDo;

public class EmployeeDaoProxy implements EmployeeDao {
    private final EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDao.create(client, obj);
            return;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void delete(String client, String employeeId) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDao.delete(client, employeeId);
            return;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public EmployeeDo get(String client, String employeeId) throws Exception {
        if (client.equals("ADMIN")) {
            return employeeDao.get(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}
