package com.hyy.dao;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 16:09
 * @Description:com.hyy.dao
 * @Version: 1.0
 */

import com.hyy.pojo.Department;
import com.hyy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * EmployeeDao
 * <功能详细描述>
 *
 * @author 周宇峰
 * @version [版本号, 2021/4/23 16:09]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Repository
public class EmployeeDao {

    //员工有所属的部门
    private  static Map<Integer, Employee> employees=null;


    //模拟数据库操作  员工dao层
    @Autowired
   private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer,Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"aa","123@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"bb","123@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"cc","123@qq.com",1,new Department(103,"后勤部")));
        employees.put(1004,new Employee(1004,"dd","123@qq.com",0,new Department(104,"开发部")));
        employees.put(1005,new Employee(1005,"ee","123@qq.com",1,new Department(105,"研发部")));

    }

    //主键自增
    private  static Integer initId =1006;

    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee>getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除一个员工
    public  void delete(Integer id){
        employees.remove(id);
    }

}
