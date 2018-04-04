package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import com.example.demo.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cassie on 2018/4/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//回滚，即测试不会对数据库造成影响
//@Transactional
public class UserMapperTest {

    @Autowired
    private UserMapper UserMapper  ;//会报错无碍

    @Test
    public void testInsert() throws Exception {
        UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
        UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
        UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception{
        List<UserEntity> users = UserMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception{
        UserEntity user = UserMapper.getOne(1);
        System.out.println(user.toString());
        user.setNickName("Cassie");
        UserMapper.update(user);
        Assert.assertTrue("Cassie".equals(UserMapper.getOne(1).getNickName()));
    }
}
