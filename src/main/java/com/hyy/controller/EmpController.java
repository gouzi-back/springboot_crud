package com.hyy.controller;/**
 * @Auther:haha
 * @Date:2021/4/25 - 04 - 25 22:53
 * @Description:com.hyy.controller
 * @Version: 1.0
 */

import com.hyy.dao.DepartmentDao;
import com.hyy.dao.EmployeeDao;
import com.hyy.pojo.Department;
import com.hyy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * EmpController
 * <功能详细描述>
 *
 * @author 员工管理
 * @version [版本号, 2021/4/25 22:53]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees= employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAdd(Model model){

        //查出所有部门的信息
        Collection<Department> department=departmentDao.getDepartment();
        model.addAttribute("department",department);
        return "emp/add";
    }

    @RequestMapping("/add")
    public String Add(Employee employee){
        //进行添加的操作
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
          Employee employeeById  =  employeeDao.getEmployeeById(id);
          model.addAttribute("employeeById",employeeById);

        //查出所有部门的信息
        Collection<Department> department=departmentDao.getDepartment();
        model.addAttribute("department",department);
        return "emp/update";
    }
    @RequestMapping("/update")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/del/{id}")
    public String Del(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
