package org.xzzzz.proj.scd.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xzzzz.proj.scd.user.entity.User;

/**
 * @Author xzzzz
 * 2020/11/7
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
