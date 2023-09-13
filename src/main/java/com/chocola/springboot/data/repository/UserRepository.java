package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);
}
