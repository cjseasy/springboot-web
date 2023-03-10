package com.jianshu.dao;

import com.jianshu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
    //模拟数据库的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();//创建一个部门表
        departments.put(101,new Department(101,"体育部"));
        departments.put(102,new Department(102,"教学部"));
        departments.put(103,new Department(103,"有关部"));
        departments.put(104,new Department(104,"无关部"));
        departments.put(105,new Department(105,"财务部"));
    }
    //获得所有部门的信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
