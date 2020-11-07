package org.xzzzz.proj.scd.movie.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xzzzz.proj.scd.movie.entity.User;
import org.xzzzz.proj.scd.movie.service.UserFeignClient;

import java.util.List;

/**
 * @Author xzzzz
 * 2020/11/7
 */
@RestController
public class MovieController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findByUser(@PathVariable("id") Long id) {
        return userFeignClient.findUserById(id);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("microservice-provider-user");
    }
}
