package org.xzzzz.proj.scd.movie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
import java.util.concurrent.TimeUnit;

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

    @HystrixCommand(fallbackMethod = "findByUserFailFallback")
    @GetMapping("/user/fallback/{id}")
    public User findByUserFail(@PathVariable("id") Long id) {
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userFeignClient.findUserById(id);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("microservice-provider-user");
    }

    /**
     * 获取用户信息失败的后备方法.
     * @param id
     * @return
     */
    public User findByUserFailFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("defaultName");
        return user;
    }

}
