package com.pawelk.javadev.repositories;


import com.pawelk.javadev.models.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresenceRepository extends JpaRepository<Presence, Long> {


    List<Presence> findByActivityId(Long activityId);

}
