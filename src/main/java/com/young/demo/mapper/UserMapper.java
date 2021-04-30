package com.young.demo.mapper;

import com.young.demo.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findById(Long id);
    User abc(Long id);
}
