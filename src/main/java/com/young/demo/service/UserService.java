package com.young.demo.service;

import com.young.demo.model.entity.User;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {
    User findById(Long id);
    User aaa(Long id);
}
