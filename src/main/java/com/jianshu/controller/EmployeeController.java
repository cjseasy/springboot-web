package com.jianshu.controller;

import com.jianshu.dao.EmployeeDao;
import com.jianshu.pojo.Employee;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.ssl.Debug;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @RequestMapping("/emps")
    public String list(Model model){
       Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        System.out.println(employees);
        return "emp/list.html";
    }
}
