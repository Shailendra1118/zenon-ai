package com.example.zenon.activitiesai.persistence.repositories;

import com.example.zenon.activitiesai.persistence.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    // additional queries

}
