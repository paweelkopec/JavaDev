package com.pawelk.javadev.repositories;

import com.pawelk.javadev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
