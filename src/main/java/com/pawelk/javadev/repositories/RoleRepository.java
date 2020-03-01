package com.pawelk.javadev.repositories;

import com.pawelk.javadev.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
    Long countByName(String name);

}
