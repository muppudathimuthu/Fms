package com.fms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
User findByEmail(String email);
}
