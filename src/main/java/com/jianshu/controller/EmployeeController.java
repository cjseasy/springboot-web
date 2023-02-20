package com.jianshu.controller;

import com.jianshu.dao.DepartmentDao;
import com.jianshu.dao.EmployeeDao;
import com.jianshu.pojo.Department;
import com.jianshu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
       Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list.html";
    }

    @GetMapping("/emp")
    public String toaddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("department",departments);
        return "emp/add.html";
    }
    @PostMapping("/emp")
    public String addemp(Employee employee){
        //添加的操作
        System.out.println("save==>"+employee);
        employeeDao.save(employee);
        //调用底层业务方法保存员工信息
        return "redirect:/emps";
    }

    //修改的操作
    @GetMapping("/emp/{id}")
    public String toUdateEmp(@PathVariable("id")Integer id,Model model){
        //查找原来的数据
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查找所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @RequestMapping("/back")
    public String back(){
        return "redirect:/emps";
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")int id,Model model){
        //查找原来的数据
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
