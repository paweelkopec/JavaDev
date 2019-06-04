package com.pawelk.javadev.controllers;

import com.pawelk.javadev.models.Activity;
import com.pawelk.javadev.models.Presence;
import com.pawelk.javadev.repositories.PresenceRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/activity/{activityId}/presence")
    Presence create(@PathVariable Long activityId, @RequestBody Presence newPresence) {
        Activity activity = new Activity();
        activity.setId(activityId);
//        if(repository.countByActivityIdAndUserId(newPresence.getActivity().getId(), newPresence.getUser().getId() )>0){
//            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity already exist");
//        }
        newPresence.setActivity(  activity);
        return repository.save(newPresence);
    }

    @DeleteMapping("/activity/{activityId}/presence/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
