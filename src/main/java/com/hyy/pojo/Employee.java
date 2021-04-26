package com.hyy.pojo;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 15:42
 * @Description:com.hyy.pojo
 * @Version: 1.0
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Employee
 * <功能详细描述>
 *
 * @author haha
 * @version [版本号, 2021/4/23 15:42]
 * @see  员工表
 * @since [产品/模块版本]
 */
@Data

@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认的创建日期
        this.birth = new Date();
    }
}
