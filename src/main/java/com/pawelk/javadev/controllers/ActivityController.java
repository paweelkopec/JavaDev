package com.pawelk.javadev.controllers;

import com.pawelk.javadev.models.Activity;
import com.pawelk.javadev.repositories.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ActivityController {

    private final ActivityRepository repository;

    public ActivityController(ActivityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/activity")
    List<Activity> all() {
        return repository.findAll();
    }

    @PostMapping("/activity")
    Activity newActivity(@RequestBody Activity newActivity) {
        return repository.save(newActivity);
    }

    @GetMapping("/activity/{id}")
    Activity  one(@PathVariable Long id) {
        return repository.findById(id) .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
    }

    @PutMapping("/activity/{id}")
    Activity update(@RequestBody Activity newActivity, @PathVariable Long id) {
        return repository.findById(id)
                .map(activity -> {
                    activity.setDescription(newActivity.getDescription());
                    activity.setTeacherDescrition(newActivity.getTeacherDescrition());
                    activity.setTitle(newActivity.getTitle());
                    return repository.save(activity);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
    }

    @DeleteMapping("/activity/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

