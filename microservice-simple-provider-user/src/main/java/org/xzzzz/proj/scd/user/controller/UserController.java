package org.xzzzz.proj.scd.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.xzzzz.proj.scd.user.dao.UserRepository;
import org.xzzzz.proj.scd.user.entity.User;

/**
 * @Author xzzzz
 * 2020/11/7
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        User findOne = userRepository.findOne(id);
        return findOne;
    }
}
