package com.example.zenon.activitiesai.service;

import com.example.zenon.activitiesai.persistence.entities.Activity;
import com.example.zenon.activitiesai.persistence.repositories.ActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;


    @Override
    public List<Activity> getAll() {
        return activityRepository.findAll();

    }

    @Override
    public Activity update(Long id, Activity activity) {
        log.info("Saving...");
        activity.setId(id);
        return activityRepository.save(activity);
    }

    @Override
    public void delete(Long id, Activity activity) {
        activity.setId(id);
        activityRepository.delete(activity);
    }

    @Override
    public Activity add(Activity activity) {
        log.info("Adding: {}", activity);
        return activityRepository.save(activity);
    }
}
