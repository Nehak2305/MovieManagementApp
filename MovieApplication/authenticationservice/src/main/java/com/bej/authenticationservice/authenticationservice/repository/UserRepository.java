package com.bej.authenticationservice.authenticationservice.repository;

import com.bej.authenticationservice.authenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    User findByEmailAndPassword(String email, String password);
}
