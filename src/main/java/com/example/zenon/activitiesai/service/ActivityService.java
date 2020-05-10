package com.example.zenon.activitiesai.service;

import com.example.zenon.activitiesai.persistence.entities.Activity;

import java.util.List;


public interface ActivityService {

    List<Activity> getAll();

    Activity update(Long id, Activity activityBo);

    void delete(Long id, Activity activityBo);

    Activity add(Activity activityBo);

}
