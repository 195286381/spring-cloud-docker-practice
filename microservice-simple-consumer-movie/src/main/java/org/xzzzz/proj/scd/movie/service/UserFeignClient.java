package org.xzzzz.proj.scd.movie.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xzzzz.proj.scd.movie.entity.User;

/**
 * @Author xzzzz
 * 2020/11/7
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    /**
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    User findUserById(@PathVariable("id") Long id);
}
