package com.pawelk.javadev.controllers;

import com.pawelk.javadev.models.Presence;
import com.pawelk.javadev.repositories.PresenceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PresenceController {

    PresenceRepository repository;

    public PresenceController(PresenceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/activity/{activityId}/presence")
    List<Presence> one(@PathVariable Long activityId) {
        return repository.findByActivityId(activityId);
    }
}
