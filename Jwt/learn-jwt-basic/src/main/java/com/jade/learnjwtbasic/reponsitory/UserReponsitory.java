package com.jade.learnjwtbasic.reponsitory;

import com.jade.learnjwtbasic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitory extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);
}
