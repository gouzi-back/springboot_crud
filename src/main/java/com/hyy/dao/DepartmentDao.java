package com.hyy.dao;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 16:00
 * @Description:com.hyy.dao
 * @Version: 1.0
 */

import com.hyy.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * DepartmentDao
 * <功能详细描述>
 *
 * @author
 * @version [版本号, 2021/4/23 16:00]
 * @see  [部门dao]
 * @since [产品/模块版本]
 */
@Repository
public class DepartmentDao {
    //初始化数据  模拟连接数据库

    private  static Map<Integer, Department> departments=null;

    static{
        departments = new HashMap<Integer,Department>();//创建一个部门表
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"后勤部"));
        departments.put(104,new Department(104,"开发部"));
        departments.put(105,new Department(105,"研发部"));

    }

    //获取所有部门信息
    public Collection<Department> getDepartment(){

        return  departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return  departments.get(id);
    }


}
