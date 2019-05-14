package cn.itsource.blackcat.service;

import cn.itsource.blackcat.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author wgb
 * @version V1.0
 * @className IEmployee
 * @description TODO
 * @date 2019/5/14 0014
 */
public interface IEmployeeService extends IService<Employee> {

    Employee login(String username, String password);
}
