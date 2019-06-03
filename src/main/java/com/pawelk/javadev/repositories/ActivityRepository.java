package com.pawelk.javadev.repositories;

import com.pawelk.javadev.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
