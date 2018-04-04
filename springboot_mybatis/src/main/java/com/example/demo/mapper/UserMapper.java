package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import com.example.demo.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Cassie on 2018/4/4.
 */
//最关键的一块，sql生产都在这里  这里的方法名都是自己定义的
public interface UserMapper {
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(int id);
    //使用@Param传参
    UserEntity findByName(@Param("nickName") String nickName);//id可以直接写

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);
//    使用对象传参   只需要语句中的#{name}、#{age}就分别对应了User对象中的name和age属性

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(int id);
}

//还有使用Map
//@Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(" +
//        "#{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{phone, jdbcType=VARCHAR})")
//int insertByMap(Map<String, Object> map);

//使用需这样
//    Map<String, Object> map = new HashMap<>();
//        map.put("name","王五");
//                map.put("password","23423");
//                map.put("phone", "13400000000");
//                userMapper.insertByMap(map);