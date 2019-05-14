package cn.itsource.blackcat.service.impl;

import cn.itsource.blackcat.domain.Employee;
import cn.itsource.blackcat.mapper.EmployeeMapper;
import cn.itsource.blackcat.service.IEmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bouncycastle.cms.PasswordRecipientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wgb
 * @version V1.0
 * @className EmployeeServiceImpl
 * @description TODO
 * @date 2019/5/14 0014
 */

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements IEmployeeService {

    @Override
    public Employee login(String username, String password) {
        Employee employee = baseMapper.selectOne(new QueryWrapper<Employee>()
                .eq("username", username).eq("password", password));
        return employee;
    }
}
