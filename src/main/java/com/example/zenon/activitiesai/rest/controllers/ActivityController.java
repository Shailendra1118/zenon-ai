package com.example.zenon.activitiesai.rest.controllers;

import com.example.zenon.activitiesai.persistence.entities.Activity;
import com.example.zenon.activitiesai.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value ="/api/v1/activities")
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }


    @GetMapping(value = "/")
    public ResponseEntity<List<Activity>> getAllActivities(){
        log.info("Request to get all activities");
        return ResponseEntity.ok().body(activityService.getAll());
    }

    @PostMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity){
        log.info("Request to create activity: {}", activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.add(activity));
    }

    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Activity> updateActivity(@PathVariable("id") Long activityId,
                                                   @RequestBody Activity activity){
        log.info("Request to update activity: {}", activity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(activityService.update(activityId, activity));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Void> deleteActivity(@PathVariable("id") Long activityId,
                                                   @RequestBody Activity activity){
        log.info("Request to update activity: {}", activity);
        activityService.delete(activityId, activity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
