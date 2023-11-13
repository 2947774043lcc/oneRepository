package com.yuntu.mapper.user.impl;

import com.yuntu.mapper.user.UserMapper;
import com.yuntu.entity.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.user.impl
 * @Author: Shuo
 * @CreateTime: 2023-10-10  15:32
 * @Description:
 * @Version: 1.0
 */
//@Component("userMapperImpl")
public class UserMapperImpl implements UserMapper {
    /*@Autowired
    @Qualifier("SqlSessionTemplate")*/
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> getUserList(User user) {
        return sqlSessionTemplate.selectList("com.yuntu.dao.user.UserMapper.getUserList",user);
    }
}
