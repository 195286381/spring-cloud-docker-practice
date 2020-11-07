package org.xzzzz.proj.scd.movie.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author xzzzz
 * 2020/11/7
 */
@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}