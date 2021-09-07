package com.atguigu.securitydemo1.mapper;

import com.atguigu.securitydemo1.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//与数据库交互
@Repository
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
