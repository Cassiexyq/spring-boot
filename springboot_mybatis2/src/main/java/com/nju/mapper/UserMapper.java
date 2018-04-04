package com.nju.mapper;

import com.nju.entity.UserEntity;

import java.util.List;

/**
 * Created by Cassie on 2018/4/4.
 */
public interface UserMapper {
      List<UserEntity> getAll();
      UserEntity getOne(int id);
      void  insert(UserEntity user);
      void  update(UserEntity user);
      void  delete(int id);

}
