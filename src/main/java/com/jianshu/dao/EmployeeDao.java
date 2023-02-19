package com.jianshu.dao;

import com.jianshu.pojo.Department;
import com.jianshu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//员工Dao
@Repository
public class EmployeeDao {
    //模拟数据库的数据
    private static Map<Integer, Employee> employees = null;
    private static Integer ininId=1006;

    static {
        employees = new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"AA","A12386@qq.com",1,new Department(101,"体育部")));
        employees.put(1002,new Employee(1002,"BB","B12386@qq.com",0,new Department(102,"教学部")));
        employees.put(1003,new Employee(1003,"CC","C12386@qq.com",1,new Department(103,"有关部")));
        employees.put(1004,new Employee(1004,"DD","D12386@qq.com",0,new Department(104,"无关部")));
        employees.put(1005,new Employee(1005,"EE","E12386@qq.com",1,new Department(105,"财务部")));
    }

    @Autowired
    private DepartmentDao departmentDao;

    private void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(ininId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById((employee.getDepartment().getId())));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return  employees.values();
    }

    private Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    private void delete(Integer id){
        employees.remove(id);
    }
}
